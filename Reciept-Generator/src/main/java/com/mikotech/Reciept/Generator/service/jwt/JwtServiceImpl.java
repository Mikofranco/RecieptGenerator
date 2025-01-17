package com.mikotech.Reciept.Generator.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static java.time.ZoneOffset.UTC;

@Service
public class JwtServiceImpl  implements JwtService{
    private final JwtConfig jwtConfig;
    private final UserDetailsService userDetailsService;

    public JwtServiceImpl(JwtConfig jwtConfig, UserDetailsService userDetailsService) {
        this.jwtConfig = jwtConfig;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String generateTokenFor(String username) {
        return JWT.create()
                .withSubject("access_token")
                .withClaim("username",username)
                .withIssuer("RECIEPT GENERATOR")
                .withExpiresAt(LocalDateTime.now().plusDays(jwtConfig.getJwtDuration())
                        .toInstant(UTC))
                .sign(HMAC512(jwtConfig.getJwtSecret().getBytes()));
    }

    @Override
    public boolean validate(String token) {
        Algorithm algorithm = HMAC512(jwtConfig.getJwtSecret().getBytes());
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .build().verify(token);
        return isValidToken(decodedJWT);
    }

    @Override
    public UserDetails extractUserDetailsFrom(String token) {
        Algorithm algorithm = HMAC512(jwtConfig.getJwtSecret().getBytes());
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .build().verify(token);
        String username =  decodedJWT.getClaim("username").as(String.class);
        return userDetailsService.loadUserByUsername(username);
    }

    private static boolean isValidToken(DecodedJWT decodedJWT) {
        return isTokenNotExpired(decodedJWT) && isTokenWithValidIssuer(decodedJWT);
    }

    private static boolean isTokenWithValidIssuer(DecodedJWT decodedJWT) {
        String issuer = decodedJWT.getIssuer();
        return issuer != null && issuer.equals("RECIEPT GENERATOR");
    }

    private static boolean isTokenNotExpired(DecodedJWT decodedJWT) {
        Instant now = Instant.now();
        Instant expiration = decodedJWT.getExpiresAt().toInstant();
        return now.isBefore(expiration);
    }
}

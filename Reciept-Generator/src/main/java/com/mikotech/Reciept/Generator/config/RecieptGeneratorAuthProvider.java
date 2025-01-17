package com.mikotech.Reciept.Generator.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class RecieptGeneratorAuthProvider implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(RecieptGeneratorAuthProvider.class);
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public RecieptGeneratorAuthProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        boolean isValidPasswordMatch = passwordEncoder.matches(password, userDetails.getPassword());
        if (isValidPasswordMatch){
            return new UsernamePasswordAuthenticationToken(username, password,
                    userDetails.getAuthorities());
        }
        log.info("Invalid Password or Username ----> {}", username);
        throw new BadCredentialsException("Incorrect credentials, username or password incorrect");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

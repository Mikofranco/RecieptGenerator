package com.mikotech.Reciept.Generator.service;

import com.mikotech.Reciept.Generator.config.RecieptGeneratorAuthProvider;
import com.mikotech.Reciept.Generator.data.modal.User;
import com.mikotech.Reciept.Generator.data.repo.UserRepo;
import com.mikotech.Reciept.Generator.dto.request.AuthenticationRequest;
import com.mikotech.Reciept.Generator.dto.request.RegisterRequest;
import com.mikotech.Reciept.Generator.dto.response.AuthenticationResponse;
import com.mikotech.Reciept.Generator.dto.response.RegisterResponse;
import com.mikotech.Reciept.Generator.service.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final RecieptGeneratorAuthProvider authProvider;
//    private final TwoFactorAuthenticationService tfaService;


    public AuthenticationServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder,
                                     JwtService jwtService, AuthenticationManager authenticationManager,
                                     UserDetailsService userDetailsService, RecieptGeneratorAuthProvider authProvider) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.authProvider = authProvider;
    }

    public RegisterResponse register(RegisterRequest request){
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setMFAEnabled(request.isMFAEnabled());

//        if(user.isMFAEnabled()){
//            user.setSecret("");
//        }
        User savedUser = userRepo.save(user);
       if(savedUser != null){
           return new RegisterResponse();
       }
       throw new RuntimeException(" User not registered");
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
    var authRes = authProvider.authenticate(request);
        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
//        if(user.isMFAEnabled()){
//            AuthenticationResponse response =new AuthenticationResponse();
//            response.setMFAEnabled(true);
//            response.setToken("");
//            response.setRefreshToken("");
//            return response;
//        }
        String token =jwtService.generateTokenFor(user.getUsername());
        AuthenticationResponse response =new AuthenticationResponse();
//        response.setMFAEnabled(user.isMFAEnabled());
        response.setToken(token);
        response.setRefreshToken("");
        return response;
    }
}

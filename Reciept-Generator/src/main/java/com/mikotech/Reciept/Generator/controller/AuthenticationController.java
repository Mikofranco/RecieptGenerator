package com.mikotech.Reciept.Generator.controller;

import com.mikotech.Reciept.Generator.dto.request.AuthenticationRequest;
import com.mikotech.Reciept.Generator.dto.request.RegisterRequest;
import com.mikotech.Reciept.Generator.dto.response.AuthenticationResponse;
import com.mikotech.Reciept.Generator.dto.response.RegisterResponse;
import com.mikotech.Reciept.Generator.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        var response = authenticationService.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        try{
            var response = authenticationService.authenticate(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    @GetMapping("/login")
    public String login(){
        return "login response";
    }

}

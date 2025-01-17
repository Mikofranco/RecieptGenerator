package com.mikotech.Reciept.Generator.service;

import com.mikotech.Reciept.Generator.dto.request.AuthenticationRequest;
import com.mikotech.Reciept.Generator.dto.request.RegisterRequest;
import com.mikotech.Reciept.Generator.dto.response.AuthenticationResponse;
import com.mikotech.Reciept.Generator.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}

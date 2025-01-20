package com.mikotech.Reciept.Generator.service;

import com.mikotech.Reciept.Generator.data.modal.Role;
import com.mikotech.Reciept.Generator.data.repo.UserRepo;
import com.mikotech.Reciept.Generator.dto.request.AuthenticationRequest;
import com.mikotech.Reciept.Generator.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthenticationServiceImplTest {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testToRegister(){
        RegisterRequest request= new RegisterRequest();
        request.setFirstname("mcheal");
        request.setLastname("Francis");
        request.setPassword("mikolo");
        request.setRole(Role.ADMIN);
        request.setUsername("ogbechiemicheal@gmail.com");
        authenticationService.register(request);
        assertEquals(1, userRepo.count());
    }

    @Test
    public  void testToLogin(){
        AuthenticationRequest request = new AuthenticationRequest();
        request.setUsername("ogbechiemicheal@gmail.com");
        request.setPassword("mikolo");
        var response = authenticationService.authenticate(request);
        System.out.println(response.getToken());
        assertNotNull(response.getToken());
    }

}
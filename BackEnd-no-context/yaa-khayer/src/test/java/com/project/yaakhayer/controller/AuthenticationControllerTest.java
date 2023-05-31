package com.project.yaakhayer.controller;

import com.project.yaakhayer.dto.AuthenticationRequest;
import com.project.yaakhayer.dto.AuthenticationResponse;
import com.project.yaakhayer.dto.SignInRequest;
import com.project.yaakhayer.entity.Role;
import com.project.yaakhayer.services.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthenticationControllerTest {
    @Autowired
    AuthenticationService service;
    @Test
    void signin() {



    }
/*
    @Test
    void authenticate() {
        AuthenticationRequest authenticationRequest1=new AuthenticationRequest();
        authenticationRequest1.setUsername("noone");
        authenticationRequest1.setPassword("password123");
        AuthenticationResponse authenticationResponse1=service.authenticate(authenticationRequest1);
        assertNotEquals(authenticationResponse1.getToken(),null);
        assertNotEquals(authenticationResponse1.getUsername(),null);
        assertNotEquals(authenticationResponse1.getRole(),null);

    }*/
}
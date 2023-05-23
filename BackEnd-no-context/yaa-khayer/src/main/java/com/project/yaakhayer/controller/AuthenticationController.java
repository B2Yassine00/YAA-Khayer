package com.project.yaakhayer.controller;


import com.project.yaakhayer.dto.AuthenticationRequest;
import com.project.yaakhayer.dto.AuthenticationResponse;
import com.project.yaakhayer.dto.SignInRequest;
import com.project.yaakhayer.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4300")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signin(@RequestBody SignInRequest request){

        return ResponseEntity.ok(service.signin(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

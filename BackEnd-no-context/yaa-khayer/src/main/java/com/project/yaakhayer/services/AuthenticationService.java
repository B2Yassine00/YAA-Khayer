package com.project.yaakhayer.services;

import com.project.yaakhayer.config.JWTService;
import com.project.yaakhayer.dao.UtilisateurRepository;
import com.project.yaakhayer.dto.AuthenticationRequest;
import com.project.yaakhayer.dto.AuthenticationResponse;
import com.project.yaakhayer.dto.SignInRequest;
import com.project.yaakhayer.entity.Role;
import com.project.yaakhayer.entity.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signin(SignInRequest request) {
        var user = Utilisateur.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        Utilisateur utilisateur=repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .role(user.getRole())
                .id(utilisateur.getId())
                .build();
    }

    public AuthenticationResponse authenticate( AuthenticationRequest userData) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getUsername(),userData.getPassword()));
        if (!repository.existsUserByUsername(userData.getUsername())){
            {
                throw new UsernameNotFoundException("User by username " + userData.getUsername() + " was not found");
            }
        }
        var user = repository.findByUsername(userData.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .username(user.getUsername())
                .role(user.getRole())
                .id(user.getId())
                .build();
    }
}

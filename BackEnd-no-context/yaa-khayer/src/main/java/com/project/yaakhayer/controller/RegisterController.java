package com.project.yaakhayer.controller;

import com.project.yaakhayer.dao.AssociationRepository;
import com.project.yaakhayer.dao.IndividuRepository;
import com.project.yaakhayer.dao.UtilisateurRepository;
import com.project.yaakhayer.dto.AuthenticationResponse;
import com.project.yaakhayer.dto.RegisterAssociationRequest;
import com.project.yaakhayer.dto.RegisterDonateurRequest;
import com.project.yaakhayer.dto.SignInRequest;
import com.project.yaakhayer.entity.Association;
import com.project.yaakhayer.entity.Individu;
import com.project.yaakhayer.entity.Utilisateur;
import com.project.yaakhayer.services.AuthenticationService;
import com.project.yaakhayer.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/register")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RegisterController {

    private AuthenticationService authService;
    private RegistrationService service;
    private AssociationRepository associationRepository;
    private IndividuRepository individuRepository;
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public RegisterController(RegistrationService service,AuthenticationService authService,
                              AssociationRepository associationRepository,IndividuRepository individuRepository,
                              UtilisateurRepository utilisateurRepository){
        this.service=service;
        this.authService=authService;
        this.associationRepository=associationRepository;
        this.individuRepository=individuRepository;
        this.utilisateurRepository=utilisateurRepository;
    }

    @PostMapping("/add-individu")
    public ResponseEntity<Individu> saveIndividu(@RequestBody RegisterDonateurRequest request){
        SignInRequest signInRequest = new SignInRequest(request.getUsername(),request.getEmail(),request.getRole(),
                request.getPassword());
        AuthenticationResponse response = authService.signin(signInRequest);
        Optional<Utilisateur> user = utilisateurRepository.findById(response.getId());
        System.out.println(request.getFirstName()+" "+request.getLastName());
        Individu individu =Individu.builder().nom(request.getLastName())
                .prenom(request.getFirstName())
                .numero(request.getNumero()).utilisateur(user.get()).build();

        Individu individu_ajouté = individuRepository.save(individu);
        System.out.println(individu_ajouté.getPrenom()+" "+individu_ajouté.getNom());
        return ResponseEntity.ok(individu_ajouté);
    }

    @PostMapping("/add-association")
    public ResponseEntity<Association> saveAssociation(@RequestBody RegisterAssociationRequest request){
        SignInRequest signInRequest = new SignInRequest(request.getUsername(),request.getEmail(),request.getRole(),
                request.getPassword());
        AuthenticationResponse response = authService.signin(signInRequest);
        Optional<Utilisateur> user = utilisateurRepository.findById(response.getId());
        Association association = new Association(request.getJustification(), user.get());
        Association association_ajouté = associationRepository.save(association);
        return ResponseEntity.ok(association_ajouté);
    }

}

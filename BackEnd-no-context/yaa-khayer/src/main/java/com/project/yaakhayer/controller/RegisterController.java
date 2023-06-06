package com.project.yaakhayer.controller;

import com.project.yaakhayer.entity.Association;
import com.project.yaakhayer.entity.Individu;
import com.project.yaakhayer.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/register")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RegisterController {

    private RegistrationService service;

    @Autowired
    public RegisterController(RegistrationService service){
        this.service=service;
    }

    @PostMapping("/add-individu")
    public ResponseEntity<Individu> saveIndividu(@RequestBody Individu  individu){

        Individu individu_ajouté = service.saveIndiv(individu);
        return ResponseEntity.ok(individu_ajouté);
    }

    @PostMapping("/add-association")
    public ResponseEntity<Association> saveAssociation(@RequestBody Association  association){


        Association association_ajouté = service.saveAssoc(association);
        return ResponseEntity.ok(association_ajouté);
    }

}

package com.project.yaakhayer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.yaakhayer.dto.AuthenticationRequest;
import com.project.yaakhayer.dto.AuthenticationResponse;
import com.project.yaakhayer.dto.SignInRequest;
import com.project.yaakhayer.entity.Role;
import com.project.yaakhayer.services.AuthenticationService;
import com.project.yaakhayer.services.RegistrationService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    RegistrationService regservice;
    @Autowired
    AuthenticationService authservice;
    private String token,tokenasso;
    String username,email,password,prenom,nom,usernameasso,emailasso,passwordasso;
    int numero=606060606;
    Long id,idasso;
    String urlsaveindividu="http://localhost:8000/api/register/add-individu";
    String urlsaveasso="http://localhost:8000/api/register/add-association";

    /******sub inscription***/
    public void subsignUp(){
        Random random = new Random();
        int randomint = random.nextInt(10000);
        username="test"+randomint;
        email="test"+randomint+"@gmail.com";
        password="test"+randomint;
        prenom="prenomtest";
        nom="nomtest";
        usernameasso="testasso"+randomint;
        emailasso="testasso"+randomint+"@gmail.com";
        passwordasso="testasso"+randomint;
        /***********Creation d'une instance d'individu**********/
        SignInRequest signInRequest=new SignInRequest(username,email, Role.individu,password);
        AuthenticationResponse authenticationResponse=authservice.signin(signInRequest);
        id=authenticationResponse.getId();
        token=authenticationResponse.getToken();
        /***********Creation d'une instance d'association**********/
        SignInRequest signInRequestasso=new SignInRequest(usernameasso,emailasso, Role.association,passwordasso);
        AuthenticationResponse authenticationResponseasso=authservice.signin(signInRequestasso);
        idasso=authenticationResponseasso.getId();
        tokenasso=authenticationResponseasso.getToken();
    }

    @Test
    public void fullScenario() throws Exception {
        subsignUp();
        /******* Continue signup for individu********/
        JSONObject request = new JSONObject();
        JSONObject utilisateur = new JSONObject();
        int id_individu= id.intValue();
        utilisateur.put("id",id_individu);
        request.put("utilisateur",utilisateur);
        request.put("prenom",prenom);
        request.put("nom",nom);
        request.put("numero",""+numero);

        mockMvc.perform(MockMvcRequestBuilders.post(urlsaveindividu)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        /*******Continue signup for association********/
        request = new JSONObject();
        JSONObject association = new JSONObject();
        int id_association= idasso.intValue();
        association.put("id",id_association);
        request.put("utilisateur",association);
        request.put("justification","Pas de jusftification");

        mockMvc.perform(MockMvcRequestBuilders.post(urlsaveasso)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenasso)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        /**** authentification of individu ***/

        AuthenticationRequest authenticationRequest1=new AuthenticationRequest(username,password);
        AuthenticationResponse authenticationResponse1=authservice.authenticate(authenticationRequest1);
        assertEquals(authenticationResponse1.getId(),id_individu);
        /**** authentification of association ***/

        AuthenticationRequest authenticationRequest2=new AuthenticationRequest(usernameasso,passwordasso);
        AuthenticationResponse authenticationResponse2=authservice.authenticate(authenticationRequest2);
        assertEquals(authenticationResponse2.getId(),id_association);
    }
    }




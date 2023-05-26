package com.project.yaakhayer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.yaakhayer.dto.*;
import com.project.yaakhayer.entity.Role;
import com.project.yaakhayer.services.AuthenticationService;
import com.project.yaakhayer.services.RegistrationService;
import net.minidev.json.JSONObject;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    RegistrationService regservice;
    private ObjectMapper objectMapper;

    @Autowired
    AuthenticationService authservice;
    private String token,tokenasso;
    String username,email,password,prenom,nom,usernameasso,emailasso,passwordasso;
    int numero=606060606;
    Long id,idasso;
    String urlsaveindividu="http://localhost:8000/api/register/add-individu";
    String urlsaveasso="http://localhost:8000/api/register/add-association";
    @BeforeAll
    public void setup(){
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

        objectMapper = new ObjectMapper();
    }

    @Test
    void testToken(){
        AuthenticationRequest authenticationRequest=new AuthenticationRequest(username,password);
        AuthenticationResponse authenticationResponse=authservice.authenticate(authenticationRequest);
        String testtoken=authenticationResponse.getToken();
        assertNotEquals(token,testtoken);
    }
    @Test
    void testTokenasso(){
        AuthenticationRequest authenticationRequest=new AuthenticationRequest(usernameasso,passwordasso);
        AuthenticationResponse authenticationResponse=authservice.authenticate(authenticationRequest);
        String testtoken=authenticationResponse.getToken();
        assertNotEquals(tokenasso,testtoken);
    }




    @Test
    @WithMockUser
    void saveIndividu() throws Exception {
     /*
        IndividuRequest individuRequest=new IndividuRequest(new UtilisateurRequest(16),prenom,nom,numero );
        String requestBody=objectMapper.writeValueAsString(individuRequest);*/
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

    }

    @Test
    void saveAssociation() throws Exception {

        JSONObject request = new JSONObject();
        JSONObject utilisateur = new JSONObject();
        int id_individu= idasso.intValue();
        utilisateur.put("id",id_individu);
        request.put("utilisateur",utilisateur);
        request.put("justification","Pas de jusftification");

        mockMvc.perform(MockMvcRequestBuilders.post(urlsaveasso)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenasso)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
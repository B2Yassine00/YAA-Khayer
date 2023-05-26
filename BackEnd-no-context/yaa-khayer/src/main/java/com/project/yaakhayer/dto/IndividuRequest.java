package com.project.yaakhayer.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndividuRequest {
    private UtilisateurRequest utilisateurRequest;
    private String prenom;
    private String nom;
    private int numero;


}

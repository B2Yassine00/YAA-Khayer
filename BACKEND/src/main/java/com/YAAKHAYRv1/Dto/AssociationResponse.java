package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociationResponse extends UtilisateurResponseDao{
    private String type;
    private String adresse;
    private String justificatifs;
    private String image;
}

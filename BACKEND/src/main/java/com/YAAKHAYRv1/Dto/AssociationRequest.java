package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociationRequest extends UtilisateurRequestDao{
    private String type;
    private String adresse;
    private String justificatifs;
    private String image;

    public AssociationRequest(String name, String password, String email, String numero, String type, String adresse, String justificatifs, String image) {
        super(name, password, email, numero);
        this.type = type;
        this.adresse = adresse;
        this.justificatifs = justificatifs;
        this.image = image;
    }
}

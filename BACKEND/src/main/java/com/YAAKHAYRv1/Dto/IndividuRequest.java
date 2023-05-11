package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndividuRequest extends UtilisateurRequestDao{

    private String infos;

    public IndividuRequest(String name, String password, String email, String numero, String infos) {
        super(name, password, email, numero);
        this.infos = infos;
    }
}

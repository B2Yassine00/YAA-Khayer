package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrendreRespondre {
    private int id_prendre;
    private int id_association;
    private int id_offert;
    private int quantite;
}

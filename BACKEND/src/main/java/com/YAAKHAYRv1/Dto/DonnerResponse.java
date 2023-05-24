package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonnerResponse {
    private int id_donner;
    private int id_donneur;
    private int id_compagne;
    private double montant;
}

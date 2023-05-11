package com.YAAKHAYRv1.Dto;

import com.YAAKHAYRv1.Models.Individu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffertRequestDto {
    private String title;
    private String description;
    private String image;
    private int etat;
    private int quantite;
    private String type;
    private Integer individuId;
}

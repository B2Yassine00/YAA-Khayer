package com.YAAKHAYRv1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompagneRequest{
    private String title;
    private String description;
    private String image;
    private Date date_publication;
    private int etat;
    private double montant;
    private String date_colture;
    private Integer associationId;

}

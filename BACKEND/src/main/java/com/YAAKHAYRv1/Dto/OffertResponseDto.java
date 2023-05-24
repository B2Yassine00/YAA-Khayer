package com.YAAKHAYRv1.Dto;

import com.YAAKHAYRv1.Models.Individu;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class OffertResponseDto {

    private int id;
    private String title;
    private String description;
    private String image;
    private Date date_publication;
    private int etat;
    private int quantite;
    private String type;
    private Integer individuId;

    public OffertResponseDto(int id, String title, String description, String image, Date date_publication, int etat, int quantite, String type, Integer individuId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date_publication = date_publication;
        this.etat = etat;
        this.quantite = quantite;
        this.type = type;
        this.individuId = individuId;
    }
}

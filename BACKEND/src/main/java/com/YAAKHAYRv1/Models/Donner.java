

package com.YAAKHAYRv1.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(
        name = "donner"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Donner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_donner;
    private int id_donneur;
    private int id_compagne;
    private double montant;

}

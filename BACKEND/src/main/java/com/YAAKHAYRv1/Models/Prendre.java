//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "prendre"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prendre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prendre;
    private int id_association;
    private int id_offert;
    private int quantite;

}



package com.YAAKHAYRv1.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Donnerkey implements Serializable {
    @Column(
            name = "id_individu"
    )
    private int id_individu;
    @Column(
            name = "id_compagne"
    )
    private int id_compagne;

    public Donnerkey() {
    }
}

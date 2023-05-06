

package com.YAAKHAYRv1.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PrendreKey implements Serializable {
    @Column(
            name = "id_association"
    )
    private int id_association;
    @Column(
            name = "id_offert"
    )
    private int id_offert;

    public PrendreKey() {
    }
}

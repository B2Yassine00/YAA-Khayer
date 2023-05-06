

package com.YAAKHAYRv1.Models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "donner"
)
public class Donner {
    @EmbeddedId
    private Donnerkey id;
    @ManyToOne
    @MapsId("id_individu")
    @JoinColumn(
            name = "id_individu"
    )
    private Individu donneur;
    @ManyToOne
    @MapsId("id_compane")
    @JoinColumn(
            name = "id_compagne"
    )
    private Compagne compagne;
    private double montant;

    public Donnerkey getId() {
        return this.id;
    }

    public void setId(Donnerkey id) {
        this.id = id;
    }

    public Donner(Individu donneur, Compagne compagne) {
        this.donneur = donneur;
        this.compagne = compagne;
    }

    public Individu getDonneur() {
        return this.donneur;
    }

    public Donner() {
    }

    public Donner(Donnerkey id, Individu donneur, Compagne compagne) {
        this.id = id;
        this.donneur = donneur;
        this.compagne = compagne;
    }

    public void setDonneur(Individu donneur) {
        this.donneur = donneur;
    }

    public Compagne getCompagne() {
        return this.compagne;
    }

    public void setCompagne(Compagne compagne) {
        this.compagne = compagne;
    }
}

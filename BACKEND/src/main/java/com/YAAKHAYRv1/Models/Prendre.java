//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "prendre"
)
public class Prendre {
    @EmbeddedId
    private PrendreKey id;
    private int quantite;
    @ManyToOne
    @MapsId("id_association")
    @JoinColumn(
            name = "id_association"
    )
    private association association;
    @ManyToOne
    @MapsId("id_offert")
    @JoinColumn(
            name = "id_offert"
    )
    private Offert offert;

    public PrendreKey getId() {
        return this.id;
    }

    public Prendre(int quantite, association association, Offert offert) {
        this.quantite = quantite;
        this.association = association;
        this.offert = offert;
    }

    public Prendre() {
    }

    public Prendre(PrendreKey id, int quantite, association association, Offert offert) {
        this.id = id;
        this.quantite = quantite;
        this.association = association;
        this.offert = offert;
    }

    public void setId(PrendreKey id) {
        this.id = id;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public association getAssociation() {
        return this.association;
    }

    public void setAssociation(association association) {
        this.association = association;
    }

    public Offert getOffert() {
        return this.offert;
    }

    public void setOffert(Offert offert) {
        this.offert = offert;
    }
}

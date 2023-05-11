//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "compagne"
)
public class Compagne extends Don implements Serializable {
    private double montant;
    private String date_colture;
    @ManyToOne
    private association association;

    public Compagne() {
    }

    public association getAssociation() {
        return this.association;
    }

    public void setAssociation(association association) {
        this.association = association;
    }

    public double getMontant() {
        return this.montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDate_colture() {
        return this.date_colture;
    }

    public void setDate_colture(String date_colture) {
        this.date_colture = date_colture;
    }

    public Compagne(int id, String title, String description, String image, Date date_publication, int etat, List<Commentaire> commentaires, double montant, String date_colture) {
        super(id, title, description, image, date_publication, etat, commentaires);
        this.montant = montant;
        this.date_colture = date_colture;
    }

    public Compagne(String title, String description, String image, Date date_publication, int etat, double montant, String date_colture) {
        super(title, description, image, date_publication, etat);
        this.montant = montant;
        this.date_colture = date_colture;
    }

    public Compagne(int id, String title, String description, String image, Date date_publication, int etat, double montant, String date_colture) {
        super(id, title, description, image, date_publication, etat);
        this.montant = montant;
        this.date_colture = date_colture;
    }
}

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
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name = "compagne"
)
public class Compagne extends Don implements Serializable {
    private double montant;
    private Date date_colture;
    @ManyToOne
    private association association;
    @OneToMany(
            mappedBy = "compagne",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Donner> donners;

    public Compagne() {
    }

    public association getAssociation() {
        return this.association;
    }

    public void setAssociation(association association) {
        this.association = association;
    }

    public List<Donner> getDonners() {
        return this.donners;
    }

    public void setDonners(List<Donner> donners) {
        this.donners = donners;
    }

    public double getMontant() {
        return this.montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate_colture() {
        return this.date_colture;
    }

    public void setDate_colture(Date date_colture) {
        this.date_colture = date_colture;
    }

    public Compagne(int id, String title, String description, String image, Date date_publication, int etat, List<Commentaire> commentaires, double montant, Date date_colture) {
        super(id, title, description, image, date_publication, etat, commentaires);
        this.montant = montant;
        this.date_colture = date_colture;
    }

    public Compagne(String title, String description, String image, Date date_publication, int etat, double montant, Date date_colture) {
        super(title, description, image, date_publication, etat);
        this.montant = montant;
        this.date_colture = date_colture;
    }

    public Compagne(int id, String title, String description, String image, Date date_publication, int etat, double montant, Date date_colture) {
        super(id, title, description, image, date_publication, etat);
        this.montant = montant;
        this.date_colture = date_colture;
    }
}

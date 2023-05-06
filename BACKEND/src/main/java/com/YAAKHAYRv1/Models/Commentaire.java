//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(
        name = "commentaire"
)
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String contenu;
    private Date date_publication;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Don don;

    public Commentaire() {
    }

    public Commentaire(int id, String contenu, Date date_publication, Utilisateur utilisateur, Don don) {
        this.id = id;
        this.contenu = contenu;
        this.date_publication = date_publication;
        this.utilisateur = utilisateur;
        this.don = don;
    }

    public Commentaire(String contenu, Date date_publication, Utilisateur utilisateur, Don don) {
        this.contenu = contenu;
        this.date_publication = date_publication;
        this.utilisateur = utilisateur;
        this.don = don;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_publication() {
        return this.date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Don getDon() {
        return this.don;
    }

    public void setDon(Don don) {
        this.don = don;
    }
}

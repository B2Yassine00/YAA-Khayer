//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.Column;
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
        name = "notifications"
)
public class Notifications implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String contenu;
    private Date date_envoi;
    @Column(
            columnDefinition = "int default 0"
    )
    private int checked;
    @ManyToOne
    private Utilisateur utilisateur;

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

    public Date getDate_envoi() {
        return this.date_envoi;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    public int getChecked() {
        return this.checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Notifications() {
    }

    public Notifications(String contenu, Date date_envoi, int checked, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.date_envoi = date_envoi;
        this.checked = checked;
        this.utilisateur = utilisateur;
    }

    public Notifications(int id, String contenu, Date date_envoi, int checked, Utilisateur utilisateur) {
        this.id = id;
        this.contenu = contenu;
        this.date_envoi = date_envoi;
        this.checked = checked;
        this.utilisateur = utilisateur;
    }
}

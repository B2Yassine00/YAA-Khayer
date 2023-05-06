package com.YAAKHAYRv1.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Table(
        name = "utilisateur"
)
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_utilisateur"
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String name;
    @Column(
            nullable = false
    )
    private String password;
    @Column(
            nullable = false
    )
    private String email;
    private String numero;
    @OneToMany(
            mappedBy = "utilisateur",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Commentaire> commentaires;
    @OneToMany(
            mappedBy = "utilisateur",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Notifications> notifications;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String name, String password, String email, String numero) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.numero = numero;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Utilisateur(String name, String password, String email, String numero) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.numero = numero;
    }

    public List<Commentaire> getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Notifications> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }
}

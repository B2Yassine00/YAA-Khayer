

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
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Table(
        name = "don"
)
public class Don implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @Column(
            nullable = false
    )
    private String title;
    @Column(
            columnDefinition = "VARCHAR(500)"
    )
    private String description;
    private String image;
    private Date date_publication;
    private int etat;
    @OneToMany(
            mappedBy = "don",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Commentaire> commentaires;

    public Don() {
    }

    public Don(int id, String title, String description, String image, Date date_publication, int etat, List<Commentaire> commentaires) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date_publication = date_publication;
        this.etat = etat;
        this.commentaires = commentaires;
    }

    public Don(int id, String title, String description, String image, Date date_publication, int etat) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date_publication = date_publication;
        this.etat = etat;
    }

    public Don(String title, String description, String image, Date date_publication, int etat) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.date_publication = date_publication;
        this.etat = etat;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate_publication() {
        return this.date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public int getEtat() {
        return this.etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<Commentaire> getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}

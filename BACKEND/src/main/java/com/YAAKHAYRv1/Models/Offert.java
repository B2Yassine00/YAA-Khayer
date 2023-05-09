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
import java.util.Optional;

@Entity
@Table(
        name = "offert"
)
public class Offert extends Don implements Serializable {
    private int quantite;
    private String type;
    @ManyToOne
    private Individu individu;
    @OneToMany(
            mappedBy = "offert",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Prendre> prendres;
    public Offert() {
    }

    public Offert(int id, String title, String description, String image, Date date_publication, int etat, List<Commentaire> commentaires, int quantite, String type) {
        super(id, title, description, image, date_publication, etat, commentaires);
        this.quantite = quantite;
        this.type = type;
    }

    public Offert(int id, String title, String description, String image, Date date_publication, int etat, int quantite, String type) {
        super(id, title, description, image, date_publication, etat);
        this.quantite = quantite;
        this.type = type;
    }

    public Offert(int quantite, String type) {
        this.quantite = quantite;
        this.type = type;
    }

    public Offert(String title, String description, String image, Date date_publication, int etat, int quantite, String type) {
        super(title, description, image, date_publication, etat);
        this.quantite = quantite;
        this.type = type;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Individu getIndividu() {
        return this.individu;
    }

    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public List<Prendre> getPrendres() {
        return this.prendres;
    }

    public void setPrendres(List<Prendre> prendres) {
        this.prendres = prendres;
    }
}

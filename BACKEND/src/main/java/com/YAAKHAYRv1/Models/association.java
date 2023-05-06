//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "association"
)
public class association extends Utilisateur implements Serializable {
    private String type;
    private String adresse;
    private String justificatifs;
    private String image;
    @OneToMany(
            mappedBy = "association",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Compagne> compagnes;
    @OneToMany(
            mappedBy = "association",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Prendre> prendres;

    public association() {
    }

    public association(Integer id, String name, String password, String email, String numero, String type, String adresse, String justificatifs, String image) {
        super(id, name, password, email, numero);
        this.type = type;
        this.adresse = adresse;
        this.justificatifs = justificatifs;
        this.image = image;
    }

    public association(String name, String password, String email, String numero, String type, String adresse, String justificatifs, String image) {
        super(name, password, email, numero);
        this.type = type;
        this.adresse = adresse;
        this.justificatifs = justificatifs;
        this.image = image;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getJustificatifs() {
        return this.justificatifs;
    }

    public void setJustificatifs(String justificatifs) {
        this.justificatifs = justificatifs;
    }

    public String getImage() {
        return this.image;
    }

    public List<Compagne> getCompagnes() {
        return this.compagnes;
    }

    public void setCompagnes(List<Compagne> compagnes) {
        this.compagnes = compagnes;
    }

    public List<Prendre> getPrendres() {
        return this.prendres;
    }

    public void setPrendres(List<Prendre> prendres) {
        this.prendres = prendres;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

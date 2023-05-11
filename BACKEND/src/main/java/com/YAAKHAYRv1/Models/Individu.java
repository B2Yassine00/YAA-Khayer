

package com.YAAKHAYRv1.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "individu"
)
public class Individu extends Utilisateur implements Serializable {
    private String infos;
    @OneToMany(
            mappedBy = "individu",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Offert> offerts;


    public Individu() {
    }

    public Individu(Integer id, String name, String password, String email, String numero, String infos) {
        super(id, name, password, email, numero);
        this.infos = infos;
    }

    public Individu(String name, String password, String email, String numero, String infos) {
        super(name, password, email, numero);
        this.infos = infos;
    }

    public String getInfos() {
        return this.infos;
    }

    public List<Offert> getOfferts() {
        return this.offerts;
    }

    public void setOfferts(List<Offert> offerts) {
        this.offerts = offerts;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }
}

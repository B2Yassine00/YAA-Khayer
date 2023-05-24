package com.project.yaakhayer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "individu",uniqueConstraints = @UniqueConstraint(columnNames = "id_user_associé"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Individu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_individu")
    private Long id_individu;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numero")
    private int numero;

    @OneToOne
    @JoinColumn(name = "id_user_associé")
    private Utilisateur utilisateur;

    public Individu(String prenom, String nom, int numero, Utilisateur utilisateur){
        this.prenom=prenom;
        this.nom=nom;
        this.numero=numero;
        this.utilisateur=utilisateur;
    }
}

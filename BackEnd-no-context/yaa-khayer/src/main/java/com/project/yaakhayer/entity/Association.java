package com.project.yaakhayer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "association")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_association")
    private Long id_association;

    @Column(name = "justification")
    private String justification;

    @OneToOne
    @JoinColumn(name = "id_utilisateur_associe")
    private Utilisateur utilisateur;
}

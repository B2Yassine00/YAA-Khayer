package com.project.yaakhayer.services;

import com.project.yaakhayer.dao.AssociationRepository;
import com.project.yaakhayer.dao.IndividuRepository;
import com.project.yaakhayer.dao.UtilisateurRepository;
import com.project.yaakhayer.entity.Association;
import com.project.yaakhayer.entity.Individu;
import com.project.yaakhayer.entity.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private AssociationRepository associationRepository;
    private IndividuRepository individuRepository;
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public RegistrationService(AssociationRepository associationRepository,
                               IndividuRepository individuRepository,
                               UtilisateurRepository utilisateurRepository){
        this.associationRepository=associationRepository;
        this.individuRepository=individuRepository;
        this.utilisateurRepository=utilisateurRepository;
    }

    public Individu saveIndiv(Individu individu){
        Optional<Utilisateur> user = utilisateurRepository.findById(individu.getUtilisateur().getId());
        Individu tempIndiv = new Individu(individu.getPrenom(),individu.getNom(),individu.getNumero(),user.get());
        return individuRepository.save(tempIndiv);
    }

    public Association saveAssoc(Association association){

        Optional<Utilisateur> user = utilisateurRepository.findById(association.getUtilisateur().getId());
        Association tempAssoc = new Association(association.getJustification(),user.get());
        return associationRepository.save(tempAssoc);
    }

}

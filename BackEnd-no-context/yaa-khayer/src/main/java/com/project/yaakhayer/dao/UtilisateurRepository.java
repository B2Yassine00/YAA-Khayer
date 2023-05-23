package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4300")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    Optional<Utilisateur> findById(Long Id);

    Optional<Utilisateur> findByUsername(String username);
    boolean existsUserByUsername(String username);
}
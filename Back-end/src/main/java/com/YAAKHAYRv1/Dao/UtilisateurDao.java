//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Models.Utilisateur;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
    @Query("select u from Utilisateur u where u.email=:email and u.password=:password")
    Optional<Utilisateur> findUtilisateurByLogin(@Param("email") String mail, @Param("password") String password);
}

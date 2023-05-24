package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Models.Prendre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendreDao extends JpaRepository<Prendre,Integer> {

    @Query("SELECT P from Prendre P where P.id_association=:id_ass")
    List<Prendre> findassociations(@Param("id_ass") Integer id_ass);

    @Query("select P from Prendre P where P.id_offert=:id ")
    List<Prendre> findAllByOffer(Integer id);
}

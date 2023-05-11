package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Models.Donner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonnerDao extends JpaRepository<Donner, Integer> {

    @Query("select D from Donner D where D.id_compagne=:id")
    List<Donner> findAllByCompagne(@Param("id") Integer id);
    @Query("select D from Donner D where D.id_donneur=:id")
    List<Donner> findAllByIndividu(@Param("id") Integer id);


}

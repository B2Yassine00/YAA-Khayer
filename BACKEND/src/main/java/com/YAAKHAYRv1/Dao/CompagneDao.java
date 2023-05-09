package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Dto.CompagneResponse;
import com.YAAKHAYRv1.Models.Compagne;
import org.hibernate.engine.profile.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompagneDao extends JpaRepository<Compagne,Integer> {

    @Query("select C from Compagne C where C.association.id= :id")
    List<Compagne> findAllByAssociation(@Param("id") Integer id);

    @Query("select C from Compagne  C where C.etat=0")
    List<Compagne> findNotColturer();

    @Query("select max(D.id) from Don D ")
    Integer nextid();



}

package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Models.association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationDao extends JpaRepository<association,Integer> {

}

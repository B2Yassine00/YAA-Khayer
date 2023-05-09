package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Models.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonDao extends JpaRepository<Don,Integer> {
}

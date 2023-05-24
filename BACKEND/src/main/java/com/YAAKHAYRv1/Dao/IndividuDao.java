package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Dto.IndividuResponse;
import com.YAAKHAYRv1.Models.Donner;
import com.YAAKHAYRv1.Models.Individu;
import com.YAAKHAYRv1.Models.Offert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividuDao extends JpaRepository<Individu,Integer> {


}

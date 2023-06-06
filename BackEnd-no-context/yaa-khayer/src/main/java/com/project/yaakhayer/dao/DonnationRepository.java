package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.Donnation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface DonnationRepository extends JpaRepository<Donnation, Long> {

    Page<Donnation> findByCategoryId(@Param("id")Long id, Pageable pageable);

    //endpoint search/findByNameContaining?name=
    Page<Donnation> findByNameContaining(@Param("name") String name, Pageable pageable);
}

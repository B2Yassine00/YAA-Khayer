package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.Donnation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4300")
public interface DonnationRepository extends JpaRepository<Donnation, Long> {
}

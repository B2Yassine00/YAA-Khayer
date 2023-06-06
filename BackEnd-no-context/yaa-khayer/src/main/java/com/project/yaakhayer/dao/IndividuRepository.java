package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.Individu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "individu", path = "individu")
public interface IndividuRepository extends JpaRepository<Individu, Long> {

}
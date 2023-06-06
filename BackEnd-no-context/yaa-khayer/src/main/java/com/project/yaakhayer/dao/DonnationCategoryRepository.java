package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.DonnationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "donnationCategory", path = "donnation-category")
public interface DonnationCategoryRepository extends JpaRepository<DonnationCategory, Long> {

}

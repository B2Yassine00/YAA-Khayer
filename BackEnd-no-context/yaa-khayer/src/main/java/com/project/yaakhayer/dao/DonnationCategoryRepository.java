package com.project.yaakhayer.dao;

import com.project.yaakhayer.entity.DonnationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "donnationCategory", path = "donnation-category")
public interface DonnationCategoryRepository extends JpaRepository<DonnationCategory, Long> {

}

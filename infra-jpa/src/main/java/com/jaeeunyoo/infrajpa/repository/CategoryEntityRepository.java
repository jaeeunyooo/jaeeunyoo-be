package com.jaeeunyoo.infrajpa.repository;

import com.jaeeunyoo.infrajpa.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
}

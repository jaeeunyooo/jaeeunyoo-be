package com.jaeeunyoo.infrastructure.repository;

import com.jaeeunyoo.infrastructure.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
}

package com.jaeeunyoo.infrastructure.repository;

import com.jaeeunyoo.infrastructure.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogEntityRepository extends JpaRepository<BlogEntity, Integer> {
}
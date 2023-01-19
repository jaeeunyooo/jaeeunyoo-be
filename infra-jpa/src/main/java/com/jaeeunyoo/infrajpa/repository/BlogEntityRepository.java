package com.jaeeunyoo.infrajpa.repository;

import com.jaeeunyoo.infrajpa.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogEntityRepository extends JpaRepository<BlogEntity, Integer> {
}

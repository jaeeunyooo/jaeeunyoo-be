package com.jaeeunyoo.infrastructure.repository;

import com.jaeeunyoo.infrastructure.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagEntityRepository extends JpaRepository<TagEntity, Integer> {
}

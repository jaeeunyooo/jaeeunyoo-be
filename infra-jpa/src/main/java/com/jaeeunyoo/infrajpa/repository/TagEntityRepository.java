package com.jaeeunyoo.infrajpa.repository;

import com.jaeeunyoo.infrajpa.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagEntityRepository extends JpaRepository<TagEntity, Integer> {
}

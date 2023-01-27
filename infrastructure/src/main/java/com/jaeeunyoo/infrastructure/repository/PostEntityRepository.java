package com.jaeeunyoo.infrastructure.repository;

import com.jaeeunyoo.infrastructure.model.PostEntity;
import com.jaeeunyoo.infrastructure.repository.querydsl.PostEntityCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity, Integer>, PostEntityCustomRepository {
}

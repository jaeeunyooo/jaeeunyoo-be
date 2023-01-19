package com.jaeeunyoo.infrajpa.repository;

import com.jaeeunyoo.infrajpa.model.PostEntity;
import com.jaeeunyoo.infrajpa.repository.querydsl.PostEntityCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEntityRepository extends JpaRepository<PostEntity, Integer>, PostEntityCustomRepository {
}

package com.jaeeunyoo.infrastructure.repository;

import com.jaeeunyoo.infrastructure.model.MemberEntity;
import com.jaeeunyoo.infrastructure.repository.querydsl.MemberEntityCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer>, MemberEntityCustomRepository {
}

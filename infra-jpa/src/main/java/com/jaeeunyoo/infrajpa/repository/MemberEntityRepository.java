package com.jaeeunyoo.infrajpa.repository;

import com.jaeeunyoo.infrajpa.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Integer> {
}

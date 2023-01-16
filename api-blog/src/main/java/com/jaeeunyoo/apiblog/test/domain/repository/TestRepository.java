package com.jaeeunyoo.apiblog.test.domain.repository;

import com.jaeeunyoo.apiblog.test.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer>, TestCustomRepository {
}

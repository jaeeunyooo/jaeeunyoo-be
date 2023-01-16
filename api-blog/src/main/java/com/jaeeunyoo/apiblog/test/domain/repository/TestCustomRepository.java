package com.jaeeunyoo.apiblog.test.domain.repository;

import com.jaeeunyoo.apiblog.test.domain.entity.TestEntity;

import java.util.List;

public interface TestCustomRepository {

    List<TestEntity> getTestEntities();
}

package com.jaeeunyoo.apiblog.test.domain.repository;

import com.jaeeunyoo.apiblog.test.domain.entity.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jaeeunyoo.apiblog.test.domain.entity.QTestEntity.testEntity;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl implements TestCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<TestEntity> getTestEntities() {
        return jpaQueryFactory.selectFrom(testEntity).fetch();
    }
}

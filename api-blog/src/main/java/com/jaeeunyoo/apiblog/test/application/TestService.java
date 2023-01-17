package com.jaeeunyoo.apiblog.test.application;

import com.jaeeunyoo.apiblog.test.domain.entity.TestEntity;
import com.jaeeunyoo.apiblog.test.domain.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public List<TestEntity> getTestEntities() {
        return testRepository.getTestEntities();
    }
}

package com.jaeeunyoo.apiblog.test.presentaion;

import com.jaeeunyoo.apiblog.test.application.TestService;
import com.jaeeunyoo.apiblog.test.domain.entity.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<TestEntity> getTestEntities() {
        return testService.getTestEntities();
    }
}

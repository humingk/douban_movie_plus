package org.humingk.movie.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class testServiceTest {
    @Autowired
    private TestServiceImpl testService;
    @Test
    void test111() {
        testService.test111();
    }
}
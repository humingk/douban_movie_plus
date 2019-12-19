package org.humingk.movie.service.impl;

import org.humingk.movie.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author humingk
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void test111() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k2", "v1");
        System.out.println(ops.get("k1"));
    }
}

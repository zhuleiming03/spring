package spring.boot.data.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class IncrementService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    public Long string(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public Long hash(String key, String hashKey, Long number) {
        return redisTemplate.boundHashOps(key).increment(hashKey, number);
    }
}

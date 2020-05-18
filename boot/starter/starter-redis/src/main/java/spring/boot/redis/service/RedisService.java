package spring.boot.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    // ----------------- Time ------------------

    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }


    // ----------------- String --------------------

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        set(key, value, 180);
    }

    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    // ----------------- Hash --------------------

}

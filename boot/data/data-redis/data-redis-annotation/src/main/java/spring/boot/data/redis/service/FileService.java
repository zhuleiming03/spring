package spring.boot.data.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FileService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    public void setString(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getString(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}

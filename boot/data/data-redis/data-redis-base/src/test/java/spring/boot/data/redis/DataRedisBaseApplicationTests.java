package spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.redis.service.RedisService;

@SpringBootTest
class DataRedisBaseApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void insert() {
        redisService.set("key", "test");
    }

    @Test
    void select() {
        System.out.println(redisService.get("key"));
    }

    @Test
    void update() {
        redisService.set("key", "demo");
    }

    @Test
    void delete() {
        redisService.remove("key");
    }

    @Autowired
    RedisService redisService;
}

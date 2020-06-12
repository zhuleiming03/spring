package spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.redis.service.TimeoutService;

@SpringBootTest
class TimeoutTest {

    @Test
    void string() {
        timeoutService.string("key", "test", 30);
    }

    @Autowired
    TimeoutService timeoutService;
}

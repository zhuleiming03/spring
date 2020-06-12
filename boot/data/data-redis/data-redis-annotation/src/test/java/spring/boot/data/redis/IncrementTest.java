package spring.boot.data.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.redis.service.IncrementService;

@SpringBootTest
class IncrementTest {

    @Test
    void string() {
        System.out.println("count: " + incrementService.string("count"));
    }

    @Test
    void hash() {
        System.out.println("count: " + incrementService.hash("id", "refund", 2L));
    }

    @Autowired
    IncrementService incrementService;
}

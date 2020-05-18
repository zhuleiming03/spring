package spring.boot.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.redis.service.QueryService;

@SpringBootTest
class OrderTest {

    @Test
    void orderTest() {
        System.out.println("Order: " + queryService.getOrder(1234));
    }

    @Autowired
    QueryService queryService;
}

package spring.boot.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.rabbitmq.service.SenderService;

@SpringBootTest
class RabbitmqApplicationTests {

    /**
     * 需要手动创建队列 test
     */
    @Test
    void contextLoads() {
        senderService.send();
    }

    @Autowired
    SenderService senderService;
}

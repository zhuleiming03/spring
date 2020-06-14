package spring.boot.message.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.message.rabbitmq.service.SenderService;

@SpringBootTest
class MessageRabbitmqBaseApplicationTests {

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

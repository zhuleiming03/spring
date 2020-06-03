package spring.boot.starter.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.validation.domain.Message;
import spring.boot.starter.validation.service.IndexService;

@SpringBootTest
class ObjectTest {

    @Autowired
    IndexService service;

    @Test
    void success() {
        Message message = new Message(18, "This is a test message");
        System.out.println("result: " + service.messageHandler(message));
    }

    @Test
    void fail() {
        Message message = new Message();
        message.setId(1000);
        System.out.println("result: " + service.messageHandler(message));
    }
}

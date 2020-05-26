package spring.boot.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class SenderService {

    public void send() {
        String message = "Hello " + LocalDateTime.now();
        System.out.println("Sender : " + message);
        this.amqpTemplate.convertAndSend("test", message);
    }

    @Resource
    AmqpTemplate amqpTemplate;
}

package spring.boot.message.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import spring.boot.message.rabbitmq.domian.QueueInstance;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class SenderService {

    public void send() {
        String message = "Hello " + LocalDateTime.now();
        System.out.println("Sender : " + message);
        this.amqpTemplate.convertAndSend(QueueInstance.QUEUE_NAME, message);
    }

    @Resource
    AmqpTemplate amqpTemplate;
}

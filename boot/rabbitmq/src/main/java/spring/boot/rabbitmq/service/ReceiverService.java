package spring.boot.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "test")
public class ReceiverService {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}

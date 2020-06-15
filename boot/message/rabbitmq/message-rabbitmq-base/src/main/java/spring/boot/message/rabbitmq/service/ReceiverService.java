package spring.boot.message.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import spring.boot.message.rabbitmq.domian.QueueInstance;

@Service
@RabbitListener(queues = QueueInstance.QUEUE_NAME)
public class ReceiverService {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}

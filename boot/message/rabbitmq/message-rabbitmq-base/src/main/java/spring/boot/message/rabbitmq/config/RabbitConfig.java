package spring.boot.message.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;
import spring.boot.message.rabbitmq.domian.QueueInstance;

@Configuration
public class RabbitConfig {

    public Queue testQueue() {
        return new Queue(QueueInstance.QUEUE_NAME);
    }
}

package spring.boot.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public Queue helloQueue() {
        return new Queue("test");
    }
}

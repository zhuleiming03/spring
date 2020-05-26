package spring.cloud.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitChannel {

    String TOPIC = "springCloudStream";

    /**
     * 生成者
     *
     * @return
     */
    @Output(TOPIC)
    MessageChannel output();

    /**
     * 消费者
     *
     * @return
     */
    @Input(TOPIC)
    SubscribableChannel input();
}

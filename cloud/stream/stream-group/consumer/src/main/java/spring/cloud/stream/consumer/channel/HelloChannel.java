package spring.cloud.stream.consumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HelloChannel {

    String TOPIC = "springCloudStream";

    /**
     * 消费者
     *
     * @return
     */
    @Input(TOPIC)
    SubscribableChannel input();
}

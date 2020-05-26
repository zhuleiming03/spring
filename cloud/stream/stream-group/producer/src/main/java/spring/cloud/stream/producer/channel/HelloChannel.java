package spring.cloud.stream.producer.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HelloChannel {

    String TOPIC = "springCloudStream";

    /**
     * 生成者
     *
     * @return
     */
    @Output(TOPIC)
    MessageChannel output();
}

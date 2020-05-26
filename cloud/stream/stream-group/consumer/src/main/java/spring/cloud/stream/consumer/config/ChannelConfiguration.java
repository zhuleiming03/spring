package spring.cloud.stream.consumer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import spring.cloud.stream.consumer.channel.HelloChannel;

import java.time.LocalDateTime;

@EnableBinding(HelloChannel.class)
public class ChannelConfiguration {

    /**
     * 订阅者事件
     *
     * @param payload
     */
    @StreamListener(HelloChannel.TOPIC)
    public void receive(Object payload) {
        System.out.println(LocalDateTime.now() + "  Received : " + payload);
    }

}

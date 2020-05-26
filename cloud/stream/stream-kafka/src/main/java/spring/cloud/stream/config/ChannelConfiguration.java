package spring.cloud.stream.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import spring.cloud.stream.channel.HelloChannel;

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

    /**
     * 发布者事件
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = HelloChannel.TOPIC,
            poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> send() {
        return () -> new GenericMessage<>("{\"name\":\"Tom\",\"age\":24}");
    }
}

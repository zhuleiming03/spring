package spring.cloud.stream.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import spring.cloud.stream.channel.KafkaChannel;
import spring.cloud.stream.channel.RabbitChannel;
import spring.cloud.stream.domain.User;

import java.time.LocalDateTime;

@EnableBinding({RabbitChannel.class, KafkaChannel.class})
public class ChannelConfiguration {

    /**
     * 订阅者事件
     *
     * @param payload
     */
    @StreamListener(RabbitChannel.TOPIC)
    public void receiveRabbit(Object payload) {
        System.out.println(LocalDateTime.now() + "  Received : " + payload);
    }

    /**
     * 订阅者事件
     *
     * @param payload
     */
    @StreamListener(KafkaChannel.TOPIC)
    public void receiveKafka(Object payload) {
        System.out.println(LocalDateTime.now() + "  Received : " + payload);
    }

    /**
     * 发布者事件
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = KafkaChannel.TOPIC,
            poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> sendRabbit() {
        return () -> new GenericMessage<>(new User("Tom", 18));
    }

    /**
     * 发布者事件
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = RabbitChannel.TOPIC,
            poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> sendKafka() {
        return () -> new GenericMessage<>(new User("Sean", 18));
    }
}

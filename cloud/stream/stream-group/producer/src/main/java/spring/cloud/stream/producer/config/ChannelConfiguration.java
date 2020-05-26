package spring.cloud.stream.producer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import spring.cloud.stream.producer.channel.HelloChannel;
import spring.cloud.stream.producer.domain.User;
import spring.cloud.stream.producer.service.ProductMessageService;

@EnableBinding(HelloChannel.class)
public class ChannelConfiguration {

    /**
     * 发布者事件
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = HelloChannel.TOPIC,
            poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> send() {
        return new ProductMessageService();
    }
}

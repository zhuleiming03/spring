package spring.cloud.stream.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import spring.cloud.stream.channel.OneChannel;
import spring.cloud.stream.channel.TwoChannel;
import spring.cloud.stream.domain.User;

import java.time.LocalDateTime;

@EnableBinding({OneChannel.class,TwoChannel.class})
public class ChannelConfiguration {

    @StreamListener(OneChannel.INPUT)
    @SendTo(TwoChannel.OUTPUT)
    public User receiveByOne(User payload) {
        System.out.println(LocalDateTime.now() + "  one : " + payload);
        payload.setAge(payload.getAge() + 2);
        sleep();
        return payload;
    }

    @StreamListener(TwoChannel.INPUT)
    @SendTo(OneChannel.OUTPUT)
    public User receiveByTwo(User payload) {
        System.out.println(LocalDateTime.now() + "  two : " + payload);
        payload.setAge(payload.getAge() + 1);
        sleep();
        return payload;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package spring.cloud.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TwoChannel {

    String INPUT = "springCloudStream.two";
    String OUTPUT = "springCloudStream.two";

    /**
     * 生成者
     *
     * @return
     */
    @Output(OUTPUT)
    MessageChannel output();

    /**
     * 消费者
     *
     * @return
     */
    @Input(INPUT)
    SubscribableChannel input();
}

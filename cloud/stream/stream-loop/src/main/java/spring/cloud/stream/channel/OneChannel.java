package spring.cloud.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OneChannel {

    String INPUT = "springCloudStream.one";
    String OUTPUT = "springCloudStream.one";

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

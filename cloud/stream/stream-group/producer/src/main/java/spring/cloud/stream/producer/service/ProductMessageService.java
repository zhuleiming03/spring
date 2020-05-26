package spring.cloud.stream.producer.service;

import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import spring.cloud.stream.producer.domain.User;

import java.time.LocalTime;

public class ProductMessageService implements MessageSource<User> {

    @Override
    public Message<User> receive() {
        User user = new User();
        int age = LocalTime.now().getSecond();
        user.setAge(age);
        if (age % 3 == 0) {
            user.setName("Sean");
        } else {
            user.setName("Tom");
        }
        return new GenericMessage<>(user);
    }
}

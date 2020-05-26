package spring.cloud.stream.controller;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.stream.channel.OneChannel;
import spring.cloud.stream.domain.User;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Resource
    OneChannel oneChannel;

    @GetMapping("/index")
    public Boolean index() {
        User user = new User("Sean", 1);
        return oneChannel.output().send(MessageBuilder.withPayload(user).build());
    }
}

package spring.cloud.feign.ribbon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.feign.ribbon.domian.User;
import spring.cloud.feign.ribbon.service.Consumer;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class ConsumerController {

    @RequestMapping("get")
    public String getInstanceInfo() {
        return consumer.getInstanceInfo("eureka-client");
    }

    @RequestMapping("post")
    public User postUser() {
        return consumer.postUser(new User(11));
    }

    @RequestMapping("repeat")
    public User getUser() {
        return consumer.getUser();
    }

    @Resource
    private Consumer consumer;
}

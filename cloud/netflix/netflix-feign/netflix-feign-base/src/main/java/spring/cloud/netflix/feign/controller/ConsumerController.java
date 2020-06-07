package spring.cloud.netflix.feign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.netflix.feign.domian.User;
import spring.cloud.netflix.feign.service.Consumer;

import javax.annotation.Resource;

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

    @Resource
    private Consumer consumer;
}

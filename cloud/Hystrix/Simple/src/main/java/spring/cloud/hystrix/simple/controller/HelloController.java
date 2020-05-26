package spring.cloud.hystrix.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.hystrix.simple.domian.User;
import spring.cloud.hystrix.simple.service.HelloService;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @GetMapping(value = "index")
    public User helloConsumer() {
        return helloService.helloService();
    }

    @Resource
    private HelloService helloService;
}

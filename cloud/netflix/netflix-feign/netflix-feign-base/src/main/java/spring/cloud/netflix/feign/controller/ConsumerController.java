package spring.cloud.netflix.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.netflix.feign.domian.User;

@RestController
public class ConsumerController {

    @GetMapping("feign/get")
    public String getTest() {
        return "get test";
    }

    @PostMapping("feign/post")
    public User postTest() {
        return new User(11);
    }

}

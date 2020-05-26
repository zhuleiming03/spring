package spring.cloud.hystrix.extend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.UserService;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping("simple")
public class SimpleController {

    @GetMapping
    public User customByAnnotation () {
        return userService.getUserSimple(new Random().nextInt(100));
    }

    @Resource
    private UserService userService;
}

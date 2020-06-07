package spring.cloud.netflix.feign.hystrix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.netflix.feign.hystrix.domian.User;
import spring.cloud.netflix.feign.hystrix.service.UserService;

import javax.annotation.Resource;

@RestController
public class UserController {

    @RequestMapping("simulate")
    public User getSimulateUser(@RequestParam("id") Integer id) {
        return userService.getSimulateUser(id);
    }

    @Resource
    private UserService userService;
}

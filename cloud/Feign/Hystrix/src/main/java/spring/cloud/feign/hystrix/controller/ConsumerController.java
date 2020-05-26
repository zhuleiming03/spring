package spring.cloud.feign.hystrix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.feign.hystrix.domian.User;
import spring.cloud.feign.hystrix.service.ConsumerService;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @RequestMapping("simulate")
    public User getSimulateUser(@RequestParam("id") Integer id) {
        return consumerService.getSimulateUser(id);
    }

    @Resource
    private ConsumerService consumerService;
}

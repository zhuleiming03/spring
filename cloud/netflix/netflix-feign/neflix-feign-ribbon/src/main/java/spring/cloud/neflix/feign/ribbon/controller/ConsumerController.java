package spring.cloud.neflix.feign.ribbon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.neflix.feign.ribbon.service.Consumer;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @RequestMapping("ribbon")
    public String getInstanceInfo() {
        return consumer.getInstanceInfo("eureka-client");
    }

    @Resource
    private Consumer consumer;
}

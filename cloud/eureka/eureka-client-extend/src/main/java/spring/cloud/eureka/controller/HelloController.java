package spring.cloud.eureka.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @Resource
    private DiscoveryClient client;

    @RequestMapping("index")
    public String hello() {

        // 打印出所有的服务名
        System.out.printf("------ %s 当前获取获取如下服务 -----\n",
                LocalDateTime.now());
        client.getServices().forEach(System.out::println);
        return "Hello world";
    }

}

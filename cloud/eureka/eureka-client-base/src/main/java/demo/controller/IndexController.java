package demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class IndexController {

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

    @GetMapping("instances")
    public List<ServiceInstance> getInstances(@RequestParam String serviceId) {
        return client.getInstances(serviceId);
    }
}

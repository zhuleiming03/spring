package spring.cloud.netflix.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ribbon")
public class RibbonController {

    @GetMapping("index")
    public String getInstances(@RequestParam String serviceId) {
        return String.format("route %s:%s", serviceId, port);
    }

    @Value("${server.port}")
    private String port;
}

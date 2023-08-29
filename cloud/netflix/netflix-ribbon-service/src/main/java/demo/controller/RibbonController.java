package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ribbon")
public class RibbonController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String serviceId;

    @GetMapping("index")
    public String getInstances() {
        return String.format("route %s:%s", serviceId, port);
    }


}

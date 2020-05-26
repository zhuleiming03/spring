package spring.cloud.sleuth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @RequestMapping("index")
    public String hello() {
        System.out.println(LocalDateTime.now() + "  INFO client one called");
        return restTemplate.getForObject(URL, String.class);
    }

    private final static String URL = "http://client-two/index";

    @Resource
    private RestTemplate restTemplate;
}

package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private final static String SERVICE_NAME = "eureka-netflix-service";

    @RequestMapping(value = "index")
    public String helloConsumer() {
        String url = String.format("http://%s/ribbon/index", SERVICE_NAME);
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}

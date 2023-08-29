package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.name}")
    private String serviceName;

    @RequestMapping(value = "index")
    public String Index() {
        String url = String.format("http://%s/ribbon/index", serviceName);
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}

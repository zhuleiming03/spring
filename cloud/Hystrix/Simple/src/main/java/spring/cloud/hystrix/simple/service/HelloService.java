package spring.cloud.hystrix.simple.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.simple.domian.User;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class HelloService {

    @HystrixCommand(fallbackMethod = "helloFallback")
    public User helloService() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hystrix/random/{1}",
                User.class, new Random().nextInt(10));
    }

    public User helloFallback() {
        return new User(405, "EUREKA-CLIENT TIMEOUT");
    }

    @Resource
    private RestTemplate restTemplate;
}

package spring.cloud.netflix.hystrix.base.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.cloud.netflix.hystrix.base.domian.User;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class IndexService {

    @HystrixCommand(fallbackMethod = "helloFallback")
    public User index() {
        String url = String.format("http://%s/hystrix/random/{0}", SERVICE_NAME);
        return restTemplate.getForObject(url, User.class, new Random().nextInt(10));
    }

    public User helloFallback() {
        User user = new User(0);
        user.setCode("405 time out");
        return user;
    }

    @Resource
    private RestTemplate restTemplate;

    private final static String SERVICE_NAME = "eureka-client";
}

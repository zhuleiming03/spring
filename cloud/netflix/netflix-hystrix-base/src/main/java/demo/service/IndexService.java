package demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class IndexService {

    @Resource
    private RestTemplate restTemplate;

    private final static String SERVICE_NAME = "netflix-service";

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
}

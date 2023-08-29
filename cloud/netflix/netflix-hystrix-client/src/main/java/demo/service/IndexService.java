package demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.api.NoneApi;
import demo.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class IndexService {

    @Resource
    private NoneApi noneApi;

    @HystrixCommand(fallbackMethod = "clientFallback")
    public User getClientFallbackUser() {
        return noneApi.getNoneBackUser(new Random().nextInt(4));
    }

    public User clientFallback() {
        return new User(0, "client hystrix error");
    }
}

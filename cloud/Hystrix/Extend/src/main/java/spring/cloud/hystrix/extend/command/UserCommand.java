package spring.cloud.hystrix.extend.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Integer id;

    public UserCommand(RestTemplate restTemplate, Integer id) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("UserCommand")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hystrix/random/{0}",
                User.class, this.id);
    }

    @Override
    protected User getFallback() {
        return new User(0, "Code Error");
    }
}

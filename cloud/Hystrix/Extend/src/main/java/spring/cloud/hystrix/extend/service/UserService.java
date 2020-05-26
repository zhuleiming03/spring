package spring.cloud.hystrix.extend.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.command.UserCommand;
import spring.cloud.hystrix.extend.domain.User;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class UserService {

    public List<User> findAllByCode(List<Integer> ids) {
        return findBatchUser(ids);
    }

    @HystrixCollapser(
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            batchMethod = "findAllByAnnotation",
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "100"),
                    @HystrixProperty(name = "maxRequestsInBatch", value = "5")})
    public User find(Integer id) {
        return null;
    }

    @HystrixCommand
    public List<User> findAllByAnnotation(List<Integer> ids) {
        return findBatchUser(ids);
    }

    @HystrixCommand(fallbackMethod = "defaultFallBack")
    public User getUserSimple(Integer id) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hystrix/simple/{0}",
                User.class, id);
    }

    @HystrixCommand(fallbackMethod = "defaultFallBack", groupKey = "userService")
    public User getUserByAnnotation(Integer id) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hystrix/random/{0}",
                User.class, id);
    }

    @HystrixCommand(fallbackMethod = "defaultFallBack")
    public Future<User> getUserByAnnotationAsync(Integer id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://EUREKA-CLIENT/hystrix/random/{0}",
                        User.class, id);
            }
        };
    }

    public User getUserByCode(Integer id) {
        return new UserCommand(restTemplate, id).execute();
    }

    public Future<User> getUserByCodeAsync(Integer id) {
        return new UserCommand(restTemplate, id).queue();
    }

    /**
     * 函数入参除了 Throwable 外 需要和 customService 保持一致
     *
     * @param id
     * @param throwable
     * @return
     */
    private User defaultFallBack(Integer id, Throwable throwable) {
        return new User(id, "Annotation Error");
    }

    private List<User> findBatchUser(List<Integer> ids) {
        String idsString = ids.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        User[] users = restTemplate.getForObject(
                "http://EUREKA-CLIENT/hystrix/batch?ids={1}",
                User[].class,
                idsString);
        if (users != null) {
            return Arrays.asList(users);
        } else {
            return null;
        }
    }

    @Resource
    private RestTemplate restTemplate;
}

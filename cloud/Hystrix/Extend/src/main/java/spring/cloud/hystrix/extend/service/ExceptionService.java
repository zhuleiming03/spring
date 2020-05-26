package spring.cloud.hystrix.extend.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import spring.cloud.hystrix.extend.domain.User;

import javax.annotation.Resource;
import java.util.concurrent.RejectedExecutionException;

@Service
public class ExceptionService {

    /**
     * 忽略异常
     *
     * @return
     * @throws Exception
     */
    @HystrixCommand(ignoreExceptions = LocalException.class)
    public String ignoreException(Integer id) {
        try {
            System.out.println("故意丢出一个异常");
            throwLocalException();
        } catch (LocalException e) {
            System.out.println("fallback 没有被触发");
        }
        return "Hello world";
    }

    @HystrixCommand(fallbackMethod = "exceptionFallback", groupKey = "userService")
    public User errorException(Integer id) {
        return restTemplate.getForObject(
                "http://EUREKA-CLIENT/hystrix/error/{0}",
                User.class, id);
    }

    @HystrixCommand(fallbackMethod = "exceptionFallback")
    public User timeoutException(Integer id) {
        return restTemplate.getForObject(
                "http://EUREKA-CLIENT/hystrix/timeout/{0}",
                User.class, id);
    }

    @HystrixCommand(fallbackMethod = "exceptionFallback",
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "3")})
    public User parallelException(Integer id) {
        System.out.printf("访问ID：%s , 当前线程名：%s \n",
                id, Thread.currentThread().getName());
        return restTemplate.getForObject(
                "http://EUREKA-CLIENT/hystrix/simple/{0}",
                User.class, id);
    }

    @HystrixCommand(fallbackMethod = "exceptionFallback")
    public User badRequestException(Integer id) {
        throw new HystrixBadRequestException("");
    }

    @Resource
    private RestTemplate restTemplate;

    private User exceptionFallback(Integer id, Throwable throwable) {
        if (throwable instanceof LocalException) {
            return new User(0, "local exception");
        }
        if (throwable instanceof HystrixTimeoutException) {
            return new User(0, "time out exception");
        }
        if (throwable instanceof RejectedExecutionException) {
            return new User(0, "parallel rejected exception");
        }
        if (throwable instanceof HttpServerErrorException ||
                throwable instanceof HttpClientErrorException) {
            return new User(0, "third service exception");
        }
        if (throwable instanceof HystrixBadRequestException) {
            return new User(0, "bad request exception");
        }
        if (throwable instanceof RuntimeException) {
            String msg = "Hystrix circuit short-circuited and is OPEN";
            if (msg.equals(throwable.getMessage())) {
                return new User(0, "circuit break exception");
            } else {
                System.out.println("exception msg: " + throwable.getMessage());
                return new User(0, "runtime exception");
            }
        }

        return new User(0, "unknown exception");
    }

    private void throwLocalException() throws LocalException {
        throw new LocalException();
    }

    private class LocalException extends Exception {
        LocalException() {
            super();
        }
    }
}

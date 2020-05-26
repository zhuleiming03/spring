package spring.cloud.feign.hystrix.service.impl;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import spring.cloud.feign.hystrix.domian.User;
import spring.cloud.feign.hystrix.service.ConsumerService;

import java.util.concurrent.RejectedExecutionException;

@Service
public class ConsumerFactory implements FallbackFactory<ConsumerService> {

    @Override
    public ConsumerService create(Throwable throwable) {
        if (throwable instanceof HystrixTimeoutException) {
            return new ConsumerService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "time out exception");
                }
            };
        }
        if (throwable instanceof RejectedExecutionException) {
            return new ConsumerService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "parallel rejected exception");
                }
            };
        }
        if (throwable instanceof FeignException) {
            return new ConsumerService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "third service exception");
                }
            };
        }
        if (throwable instanceof RuntimeException) {
            return new ConsumerService() {
                @Override
                public User getSimulateUser(Integer id) {
                    String msg = "Hystrix circuit short-circuited and is OPEN";
                    if (msg.equals(throwable.getMessage())) {
                        return new User(0, "circuit break exception");
                    } else {
                        System.out.println("exception msg: " + throwable.getMessage());
                        return new User(0, "runtime exception");
                    }
                }
            };
        }
        return new ConsumerService() {
            @Override
            public User getSimulateUser(Integer id) {
                return new User(0, "unknown exception");
            }
        };
    }
}

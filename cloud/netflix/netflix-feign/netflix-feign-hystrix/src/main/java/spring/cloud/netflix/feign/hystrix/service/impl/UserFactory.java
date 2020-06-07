package spring.cloud.netflix.feign.hystrix.service.impl;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;
import spring.cloud.netflix.feign.hystrix.domian.User;
import spring.cloud.netflix.feign.hystrix.service.UserService;

import java.util.concurrent.RejectedExecutionException;

@Service
public class UserFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        if (throwable instanceof HystrixTimeoutException) {
            return new UserService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "time out exception");
                }
            };
        }
        if (throwable instanceof RejectedExecutionException) {
            return new UserService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "parallel rejected exception");
                }
            };
        }
        if (throwable instanceof FeignException) {
            return new UserService() {
                @Override
                public User getSimulateUser(Integer id) {
                    return new User(0, "third service exception");
                }
            };
        }
        if (throwable instanceof RuntimeException) {
            return new UserService() {
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
        return new UserService() {
            @Override
            public User getSimulateUser(Integer id) {
                return new User(0, "unknown exception");
            }
        };
    }
}

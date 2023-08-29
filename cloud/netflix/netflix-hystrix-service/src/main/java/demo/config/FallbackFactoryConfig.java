package demo.config;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import demo.api.FallbackFactoryApi;
import demo.domain.Contract;
import demo.domain.User;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.RejectedExecutionException;

@Configuration
public class FallbackFactoryConfig implements FallbackFactory<FallbackFactoryApi> {

    @Override
    public FallbackFactoryApi create(Throwable throwable) {
        if (throwable instanceof HystrixTimeoutException) {
            return id -> new User(0, Contract.SERVICE_NAME + " time out");
        }
        if (throwable instanceof RejectedExecutionException) {
            return id -> new User(0, Contract.SERVICE_NAME + " parallel rejected");
        }
        if (throwable instanceof FeignException) {
            return id -> new User(0, Contract.SERVICE_NAME + " zero error");
        }
        if (throwable instanceof RuntimeException) {
            return id -> {
                String msg = "Hystrix circuit short-circuited and is OPEN";
                if (msg.equals(throwable.getMessage())) {
                    return new User(0, "circuit break exception");
                } else {
                    System.out.println("exception msg: " + throwable.getMessage());
                    return new User(0, "runtime exception");
                }
            };
        }
        return id -> new User(0, Contract.SERVICE_NAME + " unknown exception");
    }
}

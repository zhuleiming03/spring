package demo.api;

import demo.config.FallbackFactoryConfig;
import demo.domain.Contract;
import demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = Contract.SERVICE_NAME, contextId = "FallbackFactoryApi", fallbackFactory = FallbackFactoryConfig.class)
public interface FallbackFactoryApi {

    @GetMapping("hystrix/fallback/factory/{id}")
    User getFallBackFactoryUser(@PathVariable("id") Integer id);
}

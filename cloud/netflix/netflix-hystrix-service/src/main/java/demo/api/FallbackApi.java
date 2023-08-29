package demo.api;

import demo.config.FallbackConfig;
import demo.domain.Contract;
import demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = Contract.SERVICE_NAME, contextId = "FallbackApi", fallback = FallbackConfig.class)
public interface FallbackApi {

    @GetMapping("hystrix/fallback/{id}")
    User getFallBackUser(@PathVariable("id") Integer id);
}

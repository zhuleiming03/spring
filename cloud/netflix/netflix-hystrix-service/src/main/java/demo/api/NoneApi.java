package demo.api;

import demo.domain.Contract;
import demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = Contract.SERVICE_NAME, contextId = "NoneApi")
public interface NoneApi {

    @GetMapping("hystrix/none/{id}")
    User getNoneBackUser(@PathVariable("id") Integer id);
}

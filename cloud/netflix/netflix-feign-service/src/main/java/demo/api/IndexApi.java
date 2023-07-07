package demo.api;

import demo.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "eureka-feign-service", contextId = "IndexApi")
public interface IndexApi {

    @GetMapping("feign/get")
    String getTest();

    @PostMapping("feign/post")
    String postTest(@RequestBody User user);
}

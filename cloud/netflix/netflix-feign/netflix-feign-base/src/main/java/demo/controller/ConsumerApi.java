package demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import demo.domian.User;

@FeignClient("eureka-client")
public interface ConsumerApi {

    @GetMapping(value = "feign/get")
    String getTest();

    @PostMapping(value = "feign/post")
    User postTest(@RequestBody User user);

}

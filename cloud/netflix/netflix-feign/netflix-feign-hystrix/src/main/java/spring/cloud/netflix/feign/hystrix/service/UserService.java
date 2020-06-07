package spring.cloud.netflix.feign.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.netflix.feign.hystrix.domian.User;

@FeignClient("eureka-client")
public interface UserService {

    @RequestMapping(value = "feign/simulate", method = RequestMethod.GET)
    User getSimulateUser(@RequestParam("id") Integer id);

}

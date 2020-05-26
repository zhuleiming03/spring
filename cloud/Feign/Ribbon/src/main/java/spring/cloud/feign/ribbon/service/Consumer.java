package spring.cloud.feign.ribbon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.feign.ribbon.domian.User;

@FeignClient("eureka-client")
public interface Consumer {

    @RequestMapping(value = "feign/get", method = RequestMethod.GET)
    String getInstanceInfo(@RequestParam("serviceId") String name);

    @RequestMapping(value = "feign/post", method = RequestMethod.POST)
    User postUser(@RequestBody User user);

    @RequestMapping(value = "feign/random/123", method = RequestMethod.GET)
    User getUser();
}

package spring.cloud.netflix.feign.ribbon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface Consumer {

    @RequestMapping(value = "feign/get", method = RequestMethod.GET)
    String getInstanceInfo(@RequestParam("serviceId") String name);
}

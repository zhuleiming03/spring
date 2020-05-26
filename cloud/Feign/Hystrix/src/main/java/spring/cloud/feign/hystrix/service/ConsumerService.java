package spring.cloud.feign.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.feign.hystrix.domian.User;
import spring.cloud.feign.hystrix.service.impl.ConsumerFactory;
import spring.cloud.feign.hystrix.service.impl.ConsumerServiceImpl;

@FeignClient(value = "eureka-client",
        fallbackFactory = ConsumerFactory.class)
public interface ConsumerService {

    @RequestMapping(value = "feign/simulate", method = RequestMethod.GET)
    User getSimulateUser(@RequestParam("id") Integer id);
}

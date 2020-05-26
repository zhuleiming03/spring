package spring.cloud.feign.hystrix.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.feign.hystrix.domian.User;
import spring.cloud.feign.hystrix.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public User getSimulateUser(@RequestParam("id") Integer id) {
        return new User(id, "unknown exception");
    }
}

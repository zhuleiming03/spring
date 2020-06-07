package spring.cloud.netflix.feign.hystrix.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.netflix.feign.hystrix.domian.User;
import spring.cloud.netflix.feign.hystrix.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getSimulateUser(@RequestParam("id") Integer id) {
        return new User(id, "unknown exception");
    }
}

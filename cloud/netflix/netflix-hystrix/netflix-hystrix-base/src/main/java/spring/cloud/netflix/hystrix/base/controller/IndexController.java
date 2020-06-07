package spring.cloud.netflix.hystrix.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.netflix.hystrix.base.domian.User;
import spring.cloud.netflix.hystrix.base.service.IndexService;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @GetMapping(value = "index")
    public User indexConsumer() {
        return indexService.index();
    }

    @Resource
    private IndexService indexService;
}

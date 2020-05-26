package spring.cloud.hystrix.extend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.UserService;

import javax.annotation.Resource;

/**
 * 通过编程或注解实现熔断
 */
@RestController
@RequestMapping("defined")
public class DefinedController {

    @RequestMapping(value = "annotation/{id}")
    public User customByAnnotation(@PathVariable("id") Integer id) {
        return userService.getUserByAnnotation(id);
    }

    @RequestMapping(value = "annotation/async/{id}")
    public User customByAnnotationAsync(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserByAnnotationAsync(id).get();
    }

    @RequestMapping(value = "code/{id}")
    public User customByCode(@PathVariable("id") Integer id) {
        return userService.getUserByCode(id);
    }

    @RequestMapping(value = "code/async/{id}")
    public User customByCodeAsync(@PathVariable("id") Integer id) throws Exception {
        return userService.getUserByCodeAsync(id).get();
    }

    @Resource
    UserService userService;
}

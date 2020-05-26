package spring.cloud.hystrix.extend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.hystrix.extend.command.UserCollapseCommand;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("collapse")
public class CollapseController {

    @RequestMapping(value = "annotation/{id}")
    public User userByAnnotation(@PathVariable("id") Integer id) {
        return userService.find(id);
    }

    @RequestMapping(value = "code/{id}")
    public User userByCode(@PathVariable("id") Integer id) {
        return new UserCollapseCommand(userService, id).execute();
    }

    @Resource
    private UserService userService;
}

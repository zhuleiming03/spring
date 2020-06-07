package spring.boot.starter.web.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.starter.web.rest.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("delete")
public class DeleteController {

    @Resource
    UserService userService;

    @DeleteMapping("user")
    public Boolean deleteUser(@RequestParam Integer id) {

        System.out.println("\n-------- User list delete before ------");
        userService.queryUser().values().forEach(System.out::println);

        userService.deleteUser(id);

        System.out.println("-------- User list delete after -------");
        userService.queryUser().values().forEach(System.out::println);

        return true;
    }
}

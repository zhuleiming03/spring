package spring.mvc.resttemplate.controller;

import org.springframework.web.bind.annotation.*;
import spring.mvc.resttemplate.domain.User;
import spring.mvc.resttemplate.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("put")
public class PutController {

    @Resource
    UserService userService;

    @PutMapping("user")
    public Boolean createUser(@RequestBody User userParam) {

        if (userParam == null ||
                userParam.getId() == null ||
                userParam.getName() == null ||
                userParam.getRebate() == null) {
            return false;
        }

        System.out.println("\n-------- User list put before ------");
        userService.queryUser().values().forEach(System.out::println);

        userService.updateUser(userParam);

        System.out.println("-------- User list put after -------");
        userService.queryUser().values().forEach(System.out::println);

        return true;
    }

    @PutMapping("user/id")
    public void putUser(@RequestBody User userParam, @RequestParam Integer id) {
        userParam.setId(id);
        createUser(userParam);
    }
}

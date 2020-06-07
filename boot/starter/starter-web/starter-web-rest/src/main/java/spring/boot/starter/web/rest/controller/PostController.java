package spring.boot.starter.web.rest.controller;

import org.springframework.web.bind.annotation.*;
import spring.boot.starter.web.rest.domain.User;
import spring.boot.starter.web.rest.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("post")
public class PostController {

    @Resource
    UserService userService;

    @PostMapping("user")
    public User createUser(@RequestBody User userParam) {

        if (userParam == null) {
            return null;
        }

        User user;
        // user id no exit or query user no exit  then create
        if (userParam.getId() == null) {
            user = userService.defaultUser();
        } else if (userService.readUser(userParam.getId()) == null) {
            user = userService.defaultUser();
            user.setId(userParam.getId());
        } else {
            user = userService.readUser(userParam.getId());
        }

        if (userParam.getName() != null && !userParam.getName().isEmpty()) {
            user.setName(userParam.getName());
        }

        if (userParam.getRebate() != null && userParam.getRebate() != 0) {
            user.setRebate(userParam.getRebate());
        }

        System.out.println("\n-------- User list post before ------");
        userService.queryUser().values().forEach(System.out::println);

        userService.updateUser(user);

        System.out.println("-------- User list post after -------");
        userService.queryUser().values().forEach(System.out::println);

        return user;
    }

    @PostMapping("user/id")
    public User postUser(@RequestBody User userParam, @RequestParam Integer id) {
        System.out.println("post user id: " + id);
        return createUser(userParam);
    }

    @PostMapping("cookie")
    public String getCookie(@RequestBody String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String result = name;
        if (cookies != null && cookies.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Cookie cookie : cookies) {
                stringBuilder.append("name:")
                        .append(cookie.getName())
                        .append(",value:")
                        .append(cookie.getValue())
                        .append(",");
            }
            result = String.format("%s %s cookies {%s}", LocalDateTime.now(), name,
                    stringBuilder.substring(0, stringBuilder.length() - 1));
        }
        return result;
    }
}

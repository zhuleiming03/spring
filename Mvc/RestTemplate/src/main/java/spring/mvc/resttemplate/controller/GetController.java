package spring.mvc.resttemplate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.mvc.resttemplate.domain.User;
import spring.mvc.resttemplate.service.UserService;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "get")
public class GetController {

    @Resource
    UserService userService;

    @ResponseBody
    @GetMapping("all")
    public Map<Integer, User> simpleGet() {
        return userService.queryUser();
    }

    @GetMapping("list")
    @ResponseBody
    public List<User> listGet() {
        List<User> userList = new LinkedList<>();
        for (Map.Entry<Integer, User> entry : userService.queryUser().entrySet()) {
            userList.add(entry.getValue());
        }
        return userList;
    }

    @GetMapping("user")
    public ResponseEntity<User> multiplicityGet(@RequestParam Integer id) {
        User user = userService.readUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public User urlGet(@PathVariable("id") Integer id) {
        return userService.readUser(id);
    }
}

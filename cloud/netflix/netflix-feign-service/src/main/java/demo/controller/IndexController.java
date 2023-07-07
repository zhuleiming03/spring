package demo.controller;


import demo.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @GetMapping("feign/get")
    public String getTest() {
        return "feign test";
    }

    @PostMapping("feign/post")
    public String postTest(@RequestBody User user) {
        return String.format("No.%s:%s", user.getCode(), user.getName());
    }

}

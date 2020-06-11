package spring.boot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import spring.boot.swagger.domain.Response;
import spring.boot.swagger.domain.User;

import java.time.LocalDate;

@Api(tags = "基础测试")
@RestController
@RequestMapping("base")
public class IndexController {

    @ApiOperation(value = "GET 测试接口")
    @GetMapping("get")
    public Response<User> getUser(@RequestParam("id") Integer id) {
        User user = new User(id, "", LocalDate.now());
        return new Response<>(200, "", user);
    }

    @ApiOperation(value = "POST 测试接口")
    @PostMapping("post")
    public Response<User> postUser(@RequestBody User user) {
        return new Response<>(200, "", user);
    }
}

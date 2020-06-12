package spring.boot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import spring.boot.swagger.domain.Response;
import spring.boot.swagger.domain.User;

import java.time.LocalDate;

@Api(tags = "属性测试")
@RestController
@RequestMapping("base")
public class IndexController {

    @ApiOperation(value = "position 测试接口", notes = "按照指定顺序排序")
    @GetMapping("post")
    public Response<User> postUser(@RequestParam("id") Integer id) {
        return new Response<>(200, "",
                new User(id, "sean", LocalDate.now(), 18));
    }
}

package demo.controller;

import demo.api.IndexApi;
import demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Resource
    private IndexApi indexApi;

    @GetMapping("test/get")
    public String getInstanceInfo() {
        return indexApi.getTest();
    }

    @GetMapping("test/post")
    public String postUser() {
        User user = new User();
        user.setCode("1102");
        user.setName("张三");
        return indexApi.postTest(user);
    }
}

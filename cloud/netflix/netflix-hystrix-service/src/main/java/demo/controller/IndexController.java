package demo.controller;

import demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class IndexController {

    @GetMapping("hystrix/none/{id}")
    public User getNoneBackUser(@PathVariable("id") Integer id) throws InterruptedException {
        return getUser(id);
    }

    @GetMapping("hystrix/fallback/{id}")
    public User getFallBackUser(@PathVariable("id") Integer id) throws InterruptedException {
        return getUser(id);
    }

    @GetMapping("hystrix/fallback/factory/{id}")
    public User getFallBackFactoryUser(@PathVariable("id") Integer id) throws InterruptedException {
        return getUser(id);
    }

    private User getUser(Integer id) throws InterruptedException {
        System.out.printf("%s  INFO 模拟网络波动，线程休眠： %4d 毫秒\n", LocalDateTime.now(), 1100 / id);
        Thread.sleep(1100 / id);
        return new User(id);
    }
}

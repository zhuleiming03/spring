package demo.controller;

import demo.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("feign")
public class FeignController {

    @GetMapping("get")
    public String getInstances(@RequestParam String serviceId) {
        return String.format("route %s:%s", serviceId, port);
    }

    @PostMapping("post")
    public User postUser(@RequestBody User user) {
        return new User(user.getId());
    }

    @GetMapping("random/{id}")
    public User getRandomUser(@PathVariable("id") Integer id) throws InterruptedException {
        int sleepTime = new Random().nextInt(5000);
        System.out.printf("%s  INFO 模拟网络波动，线程休眠： %4d 毫秒\n",
                LocalDateTime.now(), sleepTime);
        Thread.sleep(sleepTime);
        return new User(id);
    }

    @GetMapping("simulate")
    public ResponseEntity<User> getError(@RequestParam("id") Integer id) throws InterruptedException {
        if (id == 0) {
            return ResponseEntity.badRequest().body(new User());
        } else {
            int sleepTime = id * 100;
            System.out.printf("%s  INFO 模拟网络波动，线程休眠： %4d 毫秒\n",
                    LocalDateTime.now(), sleepTime);
            Thread.sleep(sleepTime);
            return ResponseEntity.ok().body(new User(id));
        }
    }

    @Value("${server.port}")
    private String port;
}

package demo.controller;

import demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("hystrix")
public class HystrixController {

    @GetMapping("random/{id}")
    public User getRandomUser(@PathVariable("id") Integer id) throws InterruptedException {
        int sleepTime = new Random().nextInt(2000);
        System.out.printf("%s  INFO 模拟网络波动，线程休眠： %4d 毫秒\n",
                LocalDateTime.now(), sleepTime);
        Thread.sleep(sleepTime);
        return new User(id);
    }

    @GetMapping("timeout/{id}")
    public User getTimeoutUser(@PathVariable("id") Integer id) throws Exception {
        System.out.printf("%s  INFO 模拟网络延迟，线程休眠： 3000 毫秒\n",
                LocalDateTime.now());
        Thread.sleep(3_000);
        return new User(id);
    }

    @GetMapping("simple/{id}")
    public User getSimpleUser(@PathVariable("id") Integer id) {
        System.out.printf("%s  INFO 获取单个用户，用户ID: %s\n",
                LocalDateTime.now(), id);
        return new User(id);
    }

    @GetMapping("batch")
    public List<User> getBatchUser(@RequestParam("ids") String ids) {
        System.out.printf("%s  INFO 获取批量用户，用户ID: %s\n",
                LocalDateTime.now(), ids);
        return Stream.of(ids.split(","))
                .map(Integer::valueOf)
                .map(User::new)
                .collect(Collectors.toList());
    }

    @GetMapping("error/{id}")
    public ResponseEntity<String> getError(@PathVariable("id") Integer id) {
        if (id == 0) {
            return ResponseEntity.badRequest().body("Error");
        } else {
            throw new RuntimeException();
        }
    }
}

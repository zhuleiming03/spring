package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/one/{tag}")
    public String doNormal(@PathVariable("tag") String tag) {
        System.out.println("【执行方法】：doNormal");
        return tag + " doNormal";
    }

    @GetMapping("/two")
    public String doWithException() {
        System.out.println("【执行方法】：doWithException");
        int a = 1 / 0;
        return "doWithException";
    }
}

package spring.cloud.hystrix.extend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.ExceptionService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 熔断异常处理
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {

    @RequestMapping(value = "parallel/{id}")
    public User parallelException(@PathVariable("id") Integer id) {
        return exceptionService.parallelException(id);
    }

    @RequestMapping(value = "timeout/{id}")
    public User timeoutException(@PathVariable("id") Integer id) {
        return exceptionService.timeoutException(id);
    }

    @RequestMapping(value = "error/{id}")
    public User errorException(@PathVariable("id") Integer id) {
        return exceptionService.errorException(id);
    }

    @RequestMapping(value = "ignore")
    public String ignoreException() {
        return exceptionService.ignoreException(0);
    }

    @RequestMapping(value = "bad/{id}")
    public User badRequestException(@PathVariable("id") Integer id) {
        return exceptionService.badRequestException(id);
    }

    @Resource
    private ExceptionService exceptionService;
}

package spring.boot.starter.validation.controller;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.starter.validation.domain.Message;
import spring.boot.starter.validation.service.ValidatorSerivce;

import java.util.List;

@RestController
public class IndexController {

    @PostMapping("/index")
    public String index(@Validated @RequestBody Message message, BindingResult bindingResult) {
        System.out.println(message);
        if (bindingResult.hasErrors()) {
            List<String> errors = ValidatorSerivce.check(message);
            return String.join(",", errors);
        }
        return "ok";
    }
}

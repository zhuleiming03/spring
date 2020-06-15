package spring.boot.starter.validation.controller;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.starter.validation.domain.Message;
import spring.boot.starter.validation.domain.ValidGroup;
import spring.boot.starter.validation.service.ValidatorSerivce;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    @PostMapping("/query")
    public String query(@Validated(ValidGroup.QueryType.class) @RequestBody Message message,
                        BindingResult bindingResult) {
        System.out.println(message);
        return getResult(bindingResult);
    }

    @PostMapping("/alter")
    public String alter(@Validated(ValidGroup.AlterType.class) @RequestBody Message message,
                        BindingResult bindingResult) {
        System.out.println(message);
        return getResult(bindingResult);
    }

    private String getResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors()
                    .stream()
                    .map(i -> StringUtils.arrayToDelimitedString(i.getCodes(), ","))
                    .collect(Collectors.joining());
        }
        return "ok";
    }
}

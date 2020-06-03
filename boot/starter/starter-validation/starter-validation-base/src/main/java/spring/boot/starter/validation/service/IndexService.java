package spring.boot.starter.validation.service;

import org.springframework.stereotype.Service;
import spring.boot.starter.validation.domain.Message;

import java.util.List;

@Service
public class IndexService {

    public boolean messageHandler(Message message) {
        List<String> errors = ValidatorSerivce.check(message);
        if (errors.size() > 0) {
            errors.forEach(System.out::println);
            return false;
        } else {
            System.out.println(message);
            return true;
        }
    }
}

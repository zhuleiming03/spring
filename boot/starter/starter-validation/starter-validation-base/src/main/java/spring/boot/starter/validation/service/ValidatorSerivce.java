package spring.boot.starter.validation.service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatorSerivce {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private static Validator validator = validatorFactory.getValidator();

    public static <T> List<String> check(T obj) {
        return validator.validate(obj).stream()
                .map((k) -> String.format("%s -> %s", k.getPropertyPath(), k.getMessage()))
                .collect(Collectors.toList());
    }
}

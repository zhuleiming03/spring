package spring.boot.application.annotation;

import org.springframework.context.annotation.Import;
import spring.boot.application.service.SpecialService;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpecialService.class)
public @interface DefinedService {
}

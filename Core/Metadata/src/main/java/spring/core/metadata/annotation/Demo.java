package spring.core.metadata.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service(value = "service")
public @interface Demo {

    String name() default "";

    String value() default "";
}

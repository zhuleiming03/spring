package spring.annotation.conditional.annotation;

import org.springframework.context.annotation.Conditional;
import spring.annotation.conditional.service.impl.OnDefinedCondition;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnDefinedCondition.class)
public @interface ConditionalOnDefined {

    String key();

    String value();
}

package spring.annotation.aliasfor.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoOne {

    @AliasFor("param")
    String name() default "";

    @AliasFor("name")
    String param() default "";

}

package spring.core.enable.master.annotation;

import org.springframework.context.annotation.Import;
import spring.core.enable.master.service.impl.CatServiceImpl;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CatServiceImpl.class)
public @interface EnableImport {
}

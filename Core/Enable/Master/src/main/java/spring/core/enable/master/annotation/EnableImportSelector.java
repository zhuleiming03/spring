package spring.core.enable.master.annotation;

import org.springframework.context.annotation.Import;
import spring.core.enable.master.domain.Animal;
import spring.core.enable.master.service.impl.AnimalImportSelector;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AnimalImportSelector.class)
public @interface EnableImportSelector {

    Animal type();
}

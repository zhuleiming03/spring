package spring.boot.starter.validation.define;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PriceValidator.class})
public @interface Price {

    String message() default "金额必须为大于零且不能超过两位小数";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

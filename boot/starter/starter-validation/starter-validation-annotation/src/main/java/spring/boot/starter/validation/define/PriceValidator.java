package spring.boot.starter.validation.define;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @author
 */
@Component
public class PriceValidator implements ConstraintValidator<Price, BigDecimal> {

    @Override
    public void initialize(Price constraintAnnotation) {

    }

    @Override
    public boolean isValid(BigDecimal amount, ConstraintValidatorContext constraintValidatorContext) {

        // 不能为空
        if (amount == null) {
            return false;
        }

        // 必须大于等于零
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            return false;
        }

        // 小数位小于等于两位
        String stripTrailingZeros = amount.stripTrailingZeros().toPlainString();
        int index = stripTrailingZeros.indexOf(".");
        int digit = index < 0 ? 0 : stripTrailingZeros.length() - index - 1;
        return digit < 3;
    }

}

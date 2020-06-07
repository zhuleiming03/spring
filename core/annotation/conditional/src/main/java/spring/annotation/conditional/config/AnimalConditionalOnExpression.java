package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.WolfServiceImpl;

@Configuration
public class AnimalConditionalOnExpression {

    /**
     * 只有完全匹配上才能加载
     *
     * @return
     */
    @Bean
    @ConditionalOnExpression(value = "${env.expression:true}")
    public AnimalService wolfService() {
        return new WolfServiceImpl();
    }
}

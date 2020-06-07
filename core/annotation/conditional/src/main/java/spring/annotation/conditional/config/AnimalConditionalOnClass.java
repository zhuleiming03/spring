package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.CatServiceImpl;
import spring.annotation.conditional.service.impl.LionServiceImpl;

@Configuration
public class AnimalConditionalOnClass {

    /**
     * LionServiceImpl 不存在时
     *
     * @return CatServiceImpl
     */
    @Bean
    @ConditionalOnMissingClass("spring.annotation.conditional.service.impl.LionServiceImpl")
    public AnimalService defaultCatService() {
        return new CatServiceImpl();
    }

    /**
     * LionServiceImpl 存在时
     *
     * @return LionServiceImpl
     */
    @Bean
    @ConditionalOnClass(LionServiceImpl.class)
    public AnimalService lionService() {
        return new LionServiceImpl();
    }
}

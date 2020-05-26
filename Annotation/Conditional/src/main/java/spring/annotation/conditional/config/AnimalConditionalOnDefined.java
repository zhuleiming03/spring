package spring.annotation.conditional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.annotation.ConditionalOnDefined;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.LionServiceImpl;

@Configuration
public class AnimalConditionalOnDefined {

    @Bean
    @ConditionalOnDefined(key = "animal", value = "lion")
    public AnimalService lionService() {
        return new LionServiceImpl();
    }
}

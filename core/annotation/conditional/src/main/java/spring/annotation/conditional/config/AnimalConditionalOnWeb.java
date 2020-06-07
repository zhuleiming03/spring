package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.DeerServiceImpl;

/**
 * 该配置类用到了 spring-boot-starter-web
 * 需要 @EnableAutoConfiguration
 */
@EnableAutoConfiguration
@Configuration
public class AnimalConditionalOnWeb {

    /**
     * 只有在 web 运行中才能加载
     *
     * @return
     */
    @Bean
    @ConditionalOnWebApplication
    public AnimalService deerService() {
        return new DeerServiceImpl();
    }
}

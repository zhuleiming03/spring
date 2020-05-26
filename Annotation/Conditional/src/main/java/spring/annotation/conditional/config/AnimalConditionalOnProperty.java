package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.WolfServiceImpl;

@Configuration
public class AnimalConditionalOnProperty {

    /**
     * matchIfMissing = true 当不存在变量 env 默认匹配成功
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "env",
            name = "type",
            havingValue = "wolf",
            matchIfMissing = true)
    public AnimalService wolfService() {
        return new WolfServiceImpl();
    }
}

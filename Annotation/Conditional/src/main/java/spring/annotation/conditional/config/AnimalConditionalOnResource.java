package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.WolfServiceImpl;

@Configuration
public class AnimalConditionalOnResource {

    /**
     * 只有当 resources 文件夹下存在 application.factories 时 该配置才能生效
     *
     * @return
     */
    @Bean
    @ConditionalOnResource(resources = "application.properties")
    public AnimalService wolfService() {
        return new WolfServiceImpl();
    }
}

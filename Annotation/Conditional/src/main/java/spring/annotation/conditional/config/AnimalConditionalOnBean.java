package spring.annotation.conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import spring.annotation.conditional.service.AnimalService;
import spring.annotation.conditional.service.impl.CatServiceImpl;
import spring.annotation.conditional.service.impl.WolfServiceImpl;

@Configuration
public class AnimalConditionalOnBean {

    /**
     * 展示 Bean
     */
    @Bean("show")
    public void show() {
    }

    /**
     * 当不存在 Bean（name="show"） 时
     *
     * @return CatServiceImpl
     */
    @Bean
    @DependsOn("show")
    @ConditionalOnMissingBean(name = "show")
    public AnimalService defaultCatService() {
        return new CatServiceImpl();
    }

    /**
     * 当存在 Bean（name="show"） 时
     *
     * @return WolfServiceImpl
     */
    @Bean
    @DependsOn("show")
    @ConditionalOnBean(name = "show")
    public AnimalService wolfService() {
        return new WolfServiceImpl();
    }
}

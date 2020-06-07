package spring.annotation.qualifier.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.qualifier.service.Animal;

@Configuration
public class BootstrapConfiguration {

    /**
     * 同时有两个 Bean 实现 Animal 注入时, 需要指明注入哪个 Bean
     */
    @Qualifier("dog")
    @Autowired
    Animal animal;

    @Bean
    public void print() {
        animal.eat();
    }

}

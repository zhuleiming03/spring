package spring.annotation.primary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.primary.service.Animal;

@Configuration
public class BootstrapConfiguration {

    @Autowired
    Animal animal;

    @Bean
    public void print() {
        animal.eat();
    }

}

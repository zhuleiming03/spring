package spring.core.enable.slave.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeerAutoConfiguration {

    @Bean("spring.core.enable.slave.config.DeerAutoConfiguration.eat")
    public void eat() {
        System.out.println("deer eat grass");
    }
}

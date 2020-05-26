package spring.core.enable.slave.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WolfAutoConfiguration {

    @Bean("spring.core.enable.slave.config.WolfAutoConfiguration.eat")
    public void eat() {
        System.out.println("wolf eat deer");
    }
}

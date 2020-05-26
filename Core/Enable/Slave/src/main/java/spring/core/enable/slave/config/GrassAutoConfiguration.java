package spring.core.enable.slave.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrassAutoConfiguration {

    @Bean("spring.core.enable.slave.config.GrassAutoConfiguration.grow")
    @ConditionalOnClass(name = "spring.core.enable.slave.SoilAutoConfiguration")
    public void grow() {
        System.out.println("grass grow need soil");
    }
}

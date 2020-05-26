package spring.core.listener.master.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class HelloConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "env", name = "data", havingValue = "dev")
    public void queryDevData() {
    }

    @Bean
    @ConditionalOnProperty(prefix = "env", name = "data", havingValue = "prod")
    public void queryProdData() {
    }
}

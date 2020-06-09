package spring.core.config.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/service.properties")
public class BootstrapConfiguration {
}

package spring.annotation.configuration;

import org.springframework.boot.SpringApplication;
import spring.annotation.configuration.config.BootstrapConfiguration;


public class ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapConfiguration.class, args);
    }

}

package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBaseApplication.class, args);
    }

}

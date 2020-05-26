package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class ConfigServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceEurekaApplication.class, args);
    }

}

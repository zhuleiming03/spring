package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 访问 http://localhost:1001/client-base-config/prod
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServiceBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceBaseApplication.class, args);
    }

}

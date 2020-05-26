package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Profile;

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceEncryptApplication.class, args);
    }

}

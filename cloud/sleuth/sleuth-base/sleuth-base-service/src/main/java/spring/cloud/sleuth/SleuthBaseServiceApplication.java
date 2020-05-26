package spring.cloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SleuthBaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthBaseServiceApplication.class, args);
    }

}

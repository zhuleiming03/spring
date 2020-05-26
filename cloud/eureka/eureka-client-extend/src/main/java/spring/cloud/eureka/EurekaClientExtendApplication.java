package spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientExtendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientExtendApplication.class, args);
    }

}
package spring.cloud.zuul.service.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SubServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubServiceApplication.class, args);
    }

}

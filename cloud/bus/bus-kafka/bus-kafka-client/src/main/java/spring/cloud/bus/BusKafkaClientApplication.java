package spring.cloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BusKafkaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusKafkaClientApplication.class, args);
    }

}

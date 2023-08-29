package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixHystrixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixHystrixClientApplication.class, args);
    }

}

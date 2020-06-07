package spring.cloud.netflix.feign.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixFeignRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixFeignRibbonApplication.class, args);
    }

}

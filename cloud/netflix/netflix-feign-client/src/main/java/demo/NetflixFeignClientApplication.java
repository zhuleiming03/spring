package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NetflixFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixFeignClientApplication.class, args);
    }

}

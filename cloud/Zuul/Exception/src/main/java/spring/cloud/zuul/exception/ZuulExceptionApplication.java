package spring.cloud.zuul.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulExceptionApplication.class, args);
    }

}

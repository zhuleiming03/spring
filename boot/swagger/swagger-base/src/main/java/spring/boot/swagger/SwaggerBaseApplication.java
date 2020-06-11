package spring.boot.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动后访问 http://localhost:8080/swagger-ui.html
 */
@SpringBootApplication
public class SwaggerBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerBaseApplication.class, args);
    }

}

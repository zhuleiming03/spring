package spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心（单点）
 * 运行后 访问 http://localhost:1001/
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceBaseApplication.class, args);
    }

}

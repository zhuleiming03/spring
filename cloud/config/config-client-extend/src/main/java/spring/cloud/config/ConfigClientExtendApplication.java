package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 修改 git 配置后
 * post http://localhost:3001/actuator/refresh
 * 可刷新 git 配置信息
 */
@SpringBootApplication
public class ConfigClientExtendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientExtendApplication.class, args);
    }

}

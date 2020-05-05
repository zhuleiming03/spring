package spring.boot.application.starter;


import org.springframework.boot.SpringApplication;
import spring.boot.application.config.MasterConfiguration;

/**
 * 极简 Springboot 上下文的启动方式
 */
public class StarterBySpringApplicationSimple {

    public static void main(String[] args) {
        SpringApplication.run(MasterConfiguration.class, args);
    }
}

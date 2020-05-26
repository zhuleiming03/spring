package spring.annotation.depends.on.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BootstrapConfiguration {

    @Bean("before")
    public void before() {
        System.out.println("This is a before bean methid");
    }

    /**
     * after bean 会在 before bean 加载后加载
     */
    @Bean("after")
    @DependsOn("before")
    public void after() {
        System.out.println("This is a after bean methid");
    }

}

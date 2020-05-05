package spring.boot.application.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "spring.core.application")
public class MasterConfiguration {

    public MasterConfiguration() {
        System.out.println("Bean masterConfiguration create");
    }
}

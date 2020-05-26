package spring.core.example;

import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import spring.core.example.service.ExitCodeConfiguration;

/**
 * 退出码监听
 */
public class ExitCodeListenerBootstrap {

    public static void main(String[] args) {
        SpringApplication.exit(
                new SpringApplicationBuilder(ExitCodeConfiguration.class)
                        .listeners((ApplicationListener<ExitCodeEvent>) event -> {
                            System.out.println("监听到退出码：" + event.getExitCode());
                        })
                        .web(WebApplicationType.NONE)
                        .run(args));
    }
}

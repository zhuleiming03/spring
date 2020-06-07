package spring.core.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import spring.core.example.service.ExitCodeConfiguration;

/**
 * 修改退出码
 */
public class ExitCodeGeneratorBootstrap {

    public static void main(String[] args) {
        int exitCode = SpringApplication.exit(
                new SpringApplicationBuilder(ExitCodeConfiguration.class)
                        .web(WebApplicationType.NONE)
                        .run(args));
        //idea Process finished with exit code 从 0 变成了 88
        System.exit(exitCode);
    }
}

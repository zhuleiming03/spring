package spring.boot.config.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot 合计 17 种 配置源
 *
 *  4.command line (package 后在 Terminal 中执行
 *      java -jar target\config-order-0.0.1-SNAPSHOT.jar --show=4.commandLine  ）
 *  5.SPRING_APPLICATION_JSON
 *  9.java system properties
 * 10.OS environment variables
 * 15.application.properties
 * 16.PropertySource
 * 17.Default properties
 */
@SpringBootApplication
public class ConfigOrderApplication {

    public static void main(String[] args) {

        Map<String, Object> defaultProperties = new HashMap<>();
        defaultProperties.put("show", "17.Default properties");

        System.setProperty("show","9.java system properties");

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(BootstrapConfiguration.class)
                        .properties(defaultProperties)
                        .web(WebApplicationType.NONE)
                        .run(args);

        System.out.println("show: " + context.getEnvironment().getProperty("show"));

        context.close();
    }
}

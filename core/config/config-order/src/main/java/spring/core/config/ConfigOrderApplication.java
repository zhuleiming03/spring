package spring.core.config;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.core.config.config.BootstrapConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot 合计 17 种 配置源
 *
 *  4.command line ( Program arguments: --show=4.commandLine )
 *  5.SPRING_APPLICATION_JSON
 *  9.java system properties
 * 10.OS environment variables
 * 15.application.properties
 * 16.PropertySource
 * 17.Default properties
 */
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

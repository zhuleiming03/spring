package spring.core.enable.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * 自动装配
 *
 * @SpringBootApplication
 * 包含自动装配 @ComponentScan @EnableAutoConfiguration
 * 手工装配的 Bean 不能被装配到
 */
@SpringBootApplication
public class EnableApplication {

    private static final String FILTER = "spring.core.enable.";

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(EnableApplication.class, args);

        Stream.of(context.getBeanDefinitionNames()).forEach(bean -> {
            if (bean.startsWith(FILTER)) {
                System.out.println(bean);
            }
        });
    }
}

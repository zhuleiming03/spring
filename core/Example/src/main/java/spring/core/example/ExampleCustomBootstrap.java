package spring.core.example;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 自定义异常捕获
 */
public class ExampleCustomBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Object.class)
                .initializers(context -> {
                    throw new UnknownError("故意抛出异常");
                })
                .web(WebApplicationType.NONE)
                .run(args)
                .close();
    }
}

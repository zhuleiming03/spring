package spring.annotation.conditional.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.annotation.conditional.config.AnimalConditionalOnProperty;

import java.util.Properties;
import java.util.stream.Stream;

public class StarterByProperty {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new
                SpringApplicationBuilder(AnimalConditionalOnProperty.class)
                .web(WebApplicationType.NONE)
                // matchIfMissing 默认缺省 加载成功
                // 内部化配置 .properties() 加载失败
                // 外部化配置 application.properties 加载成功，覆盖内部化配置
                .properties("env.type=wolf")
                .run(args);

        Bootstrap.starterByConfiguration(context);

//        SpringApplication application = new SpringApplication(AnimalConditionalOnProperty.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        Properties properties = new Properties();
//        properties.put("env.type", "wolf");
//        application.setDefaultProperties(properties);
//        ConfigurableApplicationContext context = application.run(args);
//        Stream.of(context.getBeanDefinitionNames())
//                .sorted().forEach(System.out::println);
//        context.close();
    }
}

package spring.core.enable.master.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.core.enable.slave.config.WolfAutoConfiguration;

import java.util.stream.Stream;

/**
 * 自动装配
 * 加载 Slave 组件中的 Bean
 * 1 exclude 过滤 Bean WolfAutoConfiguration
 * 2 ConditionalOnClass 过滤 Bean grow
 * 3 变更加载顺序 默认: Chicken > Duck > Goose
 * 4 @AutoConfigurationPackage 扩大包范围
 */
@EnableAutoConfiguration(exclude = WolfAutoConfiguration.class)
public class StartByEnableAutoConfiguration {

    private static final String FILTER = "spring.core.enable.slave.";

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new
                SpringApplicationBuilder(StartByEnableAutoConfiguration.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("------------ 加载的 Bean -----------------");
        Stream.of(context.getBeanDefinitionNames())
                .forEach(bean -> {
                    if (bean.startsWith(FILTER)) {
                        System.out.println(bean);
                    }
                });

        System.out.println("------------ 加载的包范围 -----------------");
        AutoConfigurationPackages
                .get(context.getBeanFactory())
                .forEach(System.out::println);

        context.close();
    }
}

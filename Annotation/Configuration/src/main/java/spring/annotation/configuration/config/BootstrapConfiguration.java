package spring.annotation.configuration.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类有 @Configuration ,
 * 被注解的配置类进行了 CGLIB 提升
 * 没有则跟一般 Bean 一样加载
 */
@Configuration
@EnableAutoConfiguration
public class BootstrapConfiguration {

    @Bean
    public void helloWorld() {
        System.out.println("自动加载 Bean: helloWorld");
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前 Bean 实现类为： "
                    + beanFactory.getBean("helloWorld").getClass().getName());
            System.out.println("当前 配置类 实现类为： "
                    + beanFactory.getBean(BootstrapConfiguration.class).getClass().getName());

        };
    }
}

package spring.annotation.lazy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class BootstrapConfiguration {

    /**
     * @Lazy 只有被调用后才会被加载
     */
    @Bean
    @Lazy
    public void cat() {
        System.out.println("This is a cat, it is later");
    }

    @Bean
    public void lion() {
        System.out.println("This is a lion");
    }

    @Bean
    public void tiger() {
        System.out.println("This is a tiger");
    }

    @Bean
    public void leopard() {
        System.out.println("This is a leopard");
    }
}

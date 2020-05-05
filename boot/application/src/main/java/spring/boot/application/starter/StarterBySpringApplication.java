package spring.boot.application.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import spring.boot.application.config.MasterConfiguration;
import spring.boot.application.config.SlaveConfiguration;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 标准 Springboot 上下文的启动方式
 */
public class StarterBySpringApplication {

    public static void main(String[] args) {

        // 设置引导类 MasterConfiguration 到 ConfigurableApplicationContext 上下文
        SpringApplication application = new SpringApplication(MasterConfiguration.class);

        // 添加引导类 SlaveConfiguration 到 ConfigurableApplicationContext 上下文
        Collection<Class<?>> configs = new LinkedList<>();
        configs.add(SlaveConfiguration.class);
        application.addPrimarySources(configs);

        // 设置启动配置项
        application.setWebApplicationType(WebApplicationType.NONE);

        // 构建 ConfigurableApplicationContext 上下文 并运行
        ConfigurableApplicationContext context = application.run(args);

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

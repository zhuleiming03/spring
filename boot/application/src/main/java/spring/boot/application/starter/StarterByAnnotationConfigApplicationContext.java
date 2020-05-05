package spring.boot.application.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.boot.application.config.MasterConfiguration;
import spring.boot.application.config.SlaveConfiguration;

/**
 * Spring 注解模式 上下文的启动方式
 */
public class StarterByAnnotationConfigApplicationContext {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 ConfigurableApplicationContext 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 注册引导类 MasterConfiguration 到 ConfigurableApplicationContext 上下文
        context.register(MasterConfiguration.class);

        // 添加引导类 SlaveConfiguration 到 ConfigurableApplicationContext 上下文
        context.register(SlaveConfiguration.class);

        // 启动 ConfigurableApplicationContext 上下文
        context.refresh();

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

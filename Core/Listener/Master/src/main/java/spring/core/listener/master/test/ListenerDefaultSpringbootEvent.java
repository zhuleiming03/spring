package spring.core.listener.master.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import spring.core.listener.master.listener.PrintDefaultEventInfoListener;

/**
 * 监听 Springboot 默认事件
 */
public class ListenerDefaultSpringbootEvent {

    public static void main(String[] args) {

        // 非 @Configuration 充当配置项到 ConfigurableApplicationContext 上下文
        SpringApplication application = new SpringApplication(Object.class);

        // 设置启动配置项
        // 添加监听和设置运行方式为非 Web 模式
        application.addListeners(new PrintDefaultEventInfoListener<>());
        application.setWebApplicationType(WebApplicationType.NONE);

        // 构建 ConfigurableApplicationContext 上下文 并运行
        ConfigurableApplicationContext context = application.run(args);

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

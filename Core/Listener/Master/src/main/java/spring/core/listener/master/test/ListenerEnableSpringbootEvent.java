package spring.core.listener.master.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 自动加载非 ApplicationListener 类型的监听器
 */
@EnableAutoConfiguration
public class ListenerEnableSpringbootEvent {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        SpringApplication application = new SpringApplication(ListenerEnableSpringbootEvent.class);

        // 设置启动配置项
        // 添加监听和设置运行方式为非 Web 模式
        application.setWebApplicationType(WebApplicationType.NONE);

        // 构建 ConfigurableApplicationContext 上下文 并运行
        ConfigurableApplicationContext context = application.run(args);

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

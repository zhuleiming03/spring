package spring.core.listener.master.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import spring.core.listener.master.config.HelloConfiguration;
import spring.core.listener.master.initialize.HelloApplicationContextInitializer;
import spring.core.listener.master.listener.HandleDefaultEventListener;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ListenerOrder {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        SpringApplication application = new SpringApplication(HelloConfiguration.class);

        // 设置启动配置项
        // 添加自定义监听,监听默认事件
        application.addListeners(new HandleDefaultEventListener());
        // 重复添加新的初始化 Initializer , 重写 hashCode equals 方法可以去重
        application.addInitializers(new HelloApplicationContextInitializer());
        // 添加环境变量
        application.setWebApplicationType(WebApplicationType.NONE);
        Properties properties = new Properties();
        properties.put("env.data", "dev");
        application.setDefaultProperties(properties);

        // 构建 ConfigurableApplicationContext 上下文 并运行
        ConfigurableApplicationContext context = application.run(args);

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

package spring.boot.application.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.boot.application.config.MasterConfiguration;

/**
 * 流式 Springboot 上下文的启动方式
 */
public class StarterBySpringApplicationBuilder {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new
                // 设置引导类 MasterConfiguration 到 ConfigurableApplicationContext 上下文
                SpringApplicationBuilder(MasterConfiguration.class)
                // 设置启动配置项
                .web(WebApplicationType.NONE)
                // 启动
                .run(args);

        // 结束 ConfigurableApplicationContext 上下文
        context.close();
    }
}

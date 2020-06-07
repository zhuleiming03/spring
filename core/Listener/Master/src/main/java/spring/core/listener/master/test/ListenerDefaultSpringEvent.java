package spring.core.listener.master.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import spring.core.listener.master.listener.PrintDefaultEventInfoListener;

/**
 * 监听 Spring 默认事件
 */
public class ListenerDefaultSpringEvent {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        ConfigurableApplicationContext context = new GenericApplicationContext();

        // 添加自定义监听器 PrintDefaultEventInfoListener
        context.addApplicationListener(new PrintDefaultEventInfoListener<>());

        System.out.println("   refresh() 触发 Spring 应用上下文就绪事件 -------------");
        context.refresh();
        System.out.println("     start() 触发 Spring 应用上下文启动事件 -------------");
        context.start();
        System.out.println("      stop() 触发 Spring 应用上下文停止事件 -------------");
        context.stop();
        System.out.println("     close() 触发 Spring 应用上下文关闭事件 -------------");
        context.close();
    }
}

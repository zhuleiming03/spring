package spring.annotation.eventlistener.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.eventlistener.event.SystemEvent;
import spring.annotation.eventlistener.listener.SystemListener;

/**
 * 一个简单的实例
 */
public class SimpleTest {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册自定义监听器 SystemListener
        context.register(SystemListener.class);
        // 初始化上下文
        context.refresh();
        // 发布一个用户事件
        context.publishEvent(new SystemEvent("System init"));
        // 关闭上下文
        context.close();
    }
}

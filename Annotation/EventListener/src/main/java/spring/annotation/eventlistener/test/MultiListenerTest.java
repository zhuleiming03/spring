package spring.annotation.eventlistener.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.eventlistener.event.LoginEvent;
import spring.annotation.eventlistener.listener.CheckListener;
import spring.annotation.eventlistener.listener.RecordListener;

/**
 * 一个事件被多个监听器监听到
 */
public class MultiListenerTest {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册自定义监听器 CheckListener RecordListener
        context.register(CheckListener.class);
        context.register(RecordListener.class);
        // 初始化上下文
        context.refresh();
        // 发布一个用户事件
        context.publishEvent(new LoginEvent("Seam login"));
        // 关闭上下文
        context.close();
    }
}

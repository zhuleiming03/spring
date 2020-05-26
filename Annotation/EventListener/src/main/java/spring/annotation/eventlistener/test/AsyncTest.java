package spring.annotation.eventlistener.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.eventlistener.event.QueryEvent;
import spring.annotation.eventlistener.listener.AsyncListener;

/**
 * 异步监听器
 */
public class AsyncTest {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册自定义监听器 AsyncListener
        context.register(AsyncListener.class);
        // 初始化上下文
        context.refresh();
        // 发布一个用户事件
        context.publishEvent(new QueryEvent("www.baidu.com"));
        // 关闭上下文
        context.close();
    }
}

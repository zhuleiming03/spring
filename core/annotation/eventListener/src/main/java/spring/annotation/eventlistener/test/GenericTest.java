package spring.annotation.eventlistener.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.eventlistener.domain.User;
import spring.annotation.eventlistener.event.GenericEvent;
import spring.annotation.eventlistener.listener.MessageListener;
import spring.annotation.eventlistener.listener.UserListener;

/**
 * 泛型事件监听
 */
public class GenericTest {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 UserListener，即实现 ApplicationListener ，也包含 @EventListener 方法
        context.register(UserListener.class);
        context.register(MessageListener.class);
        // 初始化上下文
        context.refresh();
        // 构造泛型事件
        GenericEvent<User> eventUser = new GenericEvent(new User("Seam"));
        GenericEvent<String> eventMsg = new GenericEvent<>("System message");
        // 发送泛型事件
        context.publishEvent(eventUser);
        context.publishEvent(eventMsg);
        // 发送 User 对象作为事件源
        context.publishEvent(new User("Tom"));
        // 关闭上下文
        context.close();
    }
}

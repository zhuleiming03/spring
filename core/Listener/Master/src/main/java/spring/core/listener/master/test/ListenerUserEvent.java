package spring.core.listener.master.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import spring.core.listener.master.event.UserEvent;
import spring.core.listener.master.listener.UserEventAnnotationListener;
import spring.core.listener.master.listener.UserEventInterfaceListener;

/**
 * 监听自定义用户事件
 */
public class ListenerUserEvent {


    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 添加自定义监听器（有两种方式）
        // UserEventInterfaceListener,UserEventAnnotationListener
        context.addApplicationListener(new UserEventInterfaceListener());
        context.register(UserEventAnnotationListener.class);

        // 初始化上下文
        context.refresh();

        // 发布一个用户事件
        context.publishEvent(new UserEvent("This is a user event"));

        // 关闭上下文
        context.close();
    }

}

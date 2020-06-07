package spring.core.listener.master.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PrintDefaultEventInfoListener<E extends ApplicationEvent>
        implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {

        if (event.getSource() instanceof SpringApplication ||
                event.getSource() instanceof AnnotationConfigApplicationContext) {
            // 用于 ListenerDefaultSpringbootEvent 测试
            System.out.printf("%s  监听器事件 Event:%35s , 事件源 source:%s \n",
                    LocalDateTime.now(),
                    event.getClass().getSimpleName(),
                    event.getSource().getClass().getSimpleName());
        } else {
            // 用于 ListenerDefaultSpringEvent 测试
            System.out.printf("%s 监听器事件 Event:%s , 事件源 source:%s \n",
                    LocalTime.now(),
                    event.getClass().getSimpleName(),
                    event.getSource().getClass().getSimpleName());
        }
    }
}

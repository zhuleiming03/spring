package spring.annotation.eventlistener.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.eventlistener.event.*;
import spring.annotation.eventlistener.listener.ScreenListener;

/**
 * 一个监听器监听多个事件
 */
public class MultiEventTest {

    public static void main(String[] args) {

        // 创建 ConfigurableApplicationContext 实例
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册自定义监听器 ScreenListener
        context.register(ScreenListener.class);
        // 初始化上下文
        context.refresh();
        // 发布两个用户事件,同时触发一个监听器
        context.publishEvent(new MouseEvent("click a mouse"));
        context.publishEvent(new KeyBoardEvent("type a letter"));
        // 关闭上下文
        context.close();
    }
}

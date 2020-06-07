package spring.annotation.eventlistener.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.event.GenericEvent;

public class MessageListener implements ApplicationListener<GenericEvent<String>> {

    @EventListener
    public void onUser(String msg) {
        System.out.println("onMsg : " + msg);
    }

    @EventListener
    public void onUserEvent(GenericEvent<String> event) {
        System.out.println("onMsgEvent : " + event.getSource());
    }

    @Override
    public void onApplicationEvent(GenericEvent<String> event) {
        System.out.println("onApplicationEvent : " + event.getSource());
    }
}

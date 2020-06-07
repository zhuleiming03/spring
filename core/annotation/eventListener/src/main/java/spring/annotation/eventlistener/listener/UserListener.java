package spring.annotation.eventlistener.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.domain.User;
import spring.annotation.eventlistener.event.GenericEvent;

public class UserListener implements ApplicationListener<GenericEvent<User>> {

    @EventListener
    public void onUser(User user) {
        System.out.println("onUser : " + user);
    }

    @EventListener
    public void onUserEvent(GenericEvent<User> event) {
        System.out.println("onUserEvent : " + event.getSource());
    }

    @Override
    public void onApplicationEvent(GenericEvent<User> event) {
        System.out.println("onApplicationEvent : " + event.getSource());
    }
}

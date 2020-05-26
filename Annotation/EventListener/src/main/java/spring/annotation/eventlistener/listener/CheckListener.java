package spring.annotation.eventlistener.listener;

import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.event.LoginEvent;

public class CheckListener {

    @EventListener(LoginEvent.class)
    public void checkUser(LoginEvent event) {
        System.out.println("check listener :" + event.getSource());
    }
}

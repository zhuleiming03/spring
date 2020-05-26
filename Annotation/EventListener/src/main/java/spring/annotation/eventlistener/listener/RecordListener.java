package spring.annotation.eventlistener.listener;

import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.event.LoginEvent;

public class RecordListener {

    @EventListener(LoginEvent.class)
    public void recordUser(LoginEvent event) {
        System.out.println("record listener :" + event.getSource());
    }
}

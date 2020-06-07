package spring.annotation.eventlistener.listener;

import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.event.SystemEvent;

public class SystemListener {

    @EventListener
    public void onSystemEvent(SystemEvent event) {
        System.out.println("System event context: " + event.getSource());
    }
}



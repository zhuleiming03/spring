package spring.annotation.eventlistener.event;

import org.springframework.context.ApplicationEvent;

public class SystemEvent extends ApplicationEvent {

    public SystemEvent(String source) {
        super(source);
    }
}

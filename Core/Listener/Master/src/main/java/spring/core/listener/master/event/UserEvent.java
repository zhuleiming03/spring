package spring.core.listener.master.event;

import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    public UserEvent(String source) {
        super(source);
    }
}

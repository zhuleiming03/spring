package spring.annotation.eventlistener.event;

import org.springframework.context.ApplicationEvent;

public class LoginEvent extends ApplicationEvent {

    public LoginEvent(String source) {
        super(source);
    }
}

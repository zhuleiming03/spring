package spring.annotation.eventlistener.event;

import org.springframework.context.ApplicationEvent;

public class InputEvent extends ApplicationEvent {

    public InputEvent(String source) {
        super(source);
    }
}

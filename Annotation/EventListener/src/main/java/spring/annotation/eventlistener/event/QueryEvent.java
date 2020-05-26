package spring.annotation.eventlistener.event;

import org.springframework.context.ApplicationEvent;

public class QueryEvent extends ApplicationEvent {

    public QueryEvent(String source) {
        super(source);
    }
}

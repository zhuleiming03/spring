package behavioral.observer;

import behavioral.observer.event.ApplicationEvent;
import behavioral.observer.listener.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

public class ApplicationContext {

    private Set<ApplicationListener<ApplicationEvent>> listeners;

    public ApplicationContext() {
        this.listeners = new HashSet<>();
    }

    public void addApplicationListener(ApplicationListener<ApplicationEvent> applicationListener) {
        this.listeners.add(applicationListener);
    }

    public void pulishApplicationListener(ApplicationEvent event) {
        listeners.forEach(listener -> listener.onApplicationEvent(event));
    }
}

package behavioral.observer.listener;

import behavioral.observer.event.ApplicationEvent;
import behavioral.observer.event.MusicEvent;

public class PlayerListener<E extends ApplicationEvent> implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {
        if (event instanceof MusicEvent) {
            ((MusicEvent) event).sound();
        }
    }
}

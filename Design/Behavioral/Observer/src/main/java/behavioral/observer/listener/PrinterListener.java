package behavioral.observer.listener;

import behavioral.observer.event.ApplicationEvent;
import behavioral.observer.event.PrintEvent;

public class PrinterListener <E extends ApplicationEvent> implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {
        if (event instanceof PrintEvent){
            ((PrintEvent) event).type();
        }
    }
}
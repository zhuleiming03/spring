package spring.annotation.eventlistener.listener;

import org.springframework.context.event.EventListener;
import spring.annotation.eventlistener.event.InputEvent;
import spring.annotation.eventlistener.event.KeyBoardEvent;
import spring.annotation.eventlistener.event.MouseEvent;

public class ScreenListener {

    @EventListener({MouseEvent.class, KeyBoardEvent.class})
    public void onScreen(InputEvent event) {
        if (event instanceof MouseEvent) {
            System.out.println("screen listener find mouse event: " + event.getSource());
        }
        if (event instanceof KeyBoardEvent) {
            System.out.println("screen listener find keyboard event: " + event.getSource());
        }
    }
}

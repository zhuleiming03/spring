package behavioral.observer.event;

public class MusicEvent extends ApplicationEvent {

    public MusicEvent(Object source) {
        super(source);
    }

    public void sound() {
        System.out.println("play a music: " + this.source);
    }
}

package behavioral.observer.event;

public class PrintEvent extends ApplicationEvent {

    public PrintEvent(Object source) {
        super(source);
    }

    public void type() {
        System.out.println("print a archive: " + this.source);
    }

    public void show() {
        System.out.println("show a archive: " + this.source);
    }
}

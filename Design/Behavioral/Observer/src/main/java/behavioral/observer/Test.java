package behavioral.observer;

import behavioral.observer.event.MusicEvent;
import behavioral.observer.event.PrintEvent;
import behavioral.observer.listener.PlayerListener;
import behavioral.observer.listener.PrinterListener;
import behavioral.observer.listener.ScreenListener;

public class Test {

    public static void main(String[] args) {

        // 注册事件
        ApplicationContext context = new ApplicationContext();
        context.addApplicationListener(new PlayerListener<>());
        context.addApplicationListener(new PrinterListener<>());
        context.addApplicationListener(new ScreenListener<>());

        System.out.println("------ 单播 -------");
        context.pulishApplicationListener(new MusicEvent("my heart will go on"));
        System.out.println("------ 多播 -------");
        context.pulishApplicationListener(new PrintEvent("The Declaration of Independence"));
    }
}

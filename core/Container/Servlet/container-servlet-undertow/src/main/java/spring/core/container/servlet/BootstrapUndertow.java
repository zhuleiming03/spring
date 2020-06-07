package spring.core.container.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BootstrapUndertow {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapUndertow.class);
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 WebServer 实现类为："
                + event.getWebServer().getClass().getName());
    }
}

package spring.core.container.reative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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

    /**
     * 访问 http://localhost:8080/index
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/index"),
                request -> ok().body(Mono.just("Hello world"), String.class));
    }
}

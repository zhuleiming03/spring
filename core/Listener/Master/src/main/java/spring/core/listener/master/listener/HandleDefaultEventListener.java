package spring.core.listener.master.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HandleDefaultEventListener<E extends ApplicationEvent>
        implements ApplicationListener<E> {

    @Override
    public void onApplicationEvent(E event) {

        if (event instanceof ApplicationStartingEvent) {
            title(event);
            System.out.println();
        }

        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            title(event);
            ConfigurableEnvironment environment =
                    ((ApplicationEnvironmentPreparedEvent) event).getEnvironment();
            PropertySource<?> propertySource = environment.getPropertySources().get("defaultProperties");
            if (propertySource != null) {
                System.out.printf("%s  Default Profile： %s\n",
                        LocalDateTime.now(), propertySource.getSource());
            }
            System.out.println();
        }

        if (event instanceof ApplicationContextInitializedEvent) {
            title(event);
            System.out.println();
        }

        if (event instanceof ApplicationPreparedEvent) {
            title(event);
            ConfigurableApplicationContext context =
                    ((ApplicationPreparedEvent) event).getApplicationContext();
            ConfigurableEnvironment environment = context.getEnvironment();
            MutablePropertySources mutablePropertySources = environment.getPropertySources();
            Map<String, Object> map = new HashMap<>(1);
            map.put("env.data", "prod");
            PropertySource<?> propertySource = new MapPropertySource("defaultProperties", map);
            if (mutablePropertySources.contains("defaultProperties")) {
                mutablePropertySources.replace("defaultProperties", propertySource);
                System.out.printf("%s  Active Profile： %s\n",
                        LocalDateTime.now(), propertySource.getSource());
            }
            System.out.println();
        }

        if (event instanceof ContextRefreshedEvent) {
            title(event);
            AnnotationConfigApplicationContext context =
                    (AnnotationConfigApplicationContext) event.getSource();
            System.out.println(LocalDateTime.now() + "  refresh() 加载的 Bean 文件如下：");
            Stream.of(context.getBeanDefinitionNames())
                    .sorted()
                    .forEach(name -> System.out.printf("%s  %s \n",
                            LocalDateTime.now(), name));
            System.out.println();
        }

        if (event instanceof ApplicationStartedEvent) {
            title(event);
            System.out.println();
        }

        if (event instanceof ApplicationReadyEvent) {
            title(event);
            System.out.println();
        }

        if (event instanceof ContextClosedEvent) {
            title(event);
            System.out.println();
        }
    }

    private void title(E event) {
        System.out.printf("%s  Event:[%35s]  \n",
                LocalDateTime.now(),
                event.getClass().getSimpleName());
    }
}

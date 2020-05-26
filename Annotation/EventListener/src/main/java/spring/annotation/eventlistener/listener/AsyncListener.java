package spring.annotation.eventlistener.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import spring.annotation.eventlistener.event.QueryEvent;

@EnableAsync
public class AsyncListener {

    @EventListener(QueryEvent.class)
    @Async
    public void queryEvent(QueryEvent event) {
        System.out.printf("[%s] begin query third web [%s]... \n",
                Thread.currentThread().getName(), event.getSource());
    }

    @Bean
    public TaskExecutor getTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setCorePoolSize(2);
        return taskExecutor;
    }
}


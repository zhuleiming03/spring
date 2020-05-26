package spring.annotation.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ThreadService {

    public void sleep(long second) {
        try {
            Thread.sleep(1_000L * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void asyncMethod() {
        System.out.printf("%s  [%s] asyncMethod begin \n",
                LocalDateTime.now(), Thread.currentThread().getName());
        sleep(3);
        System.out.printf("%s  [%s] asyncMethod end \n",
                LocalDateTime.now(), Thread.currentThread().getName());
    }
}

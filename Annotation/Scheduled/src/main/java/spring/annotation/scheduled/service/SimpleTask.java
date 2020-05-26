package spring.annotation.scheduled.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SimpleTask {

    @Scheduled(cron = "0 09 16 * * ?")
    public void task(){
        System.out.println("This is a Plan Task Test!");
    }
}

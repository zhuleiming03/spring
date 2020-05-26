package spring.annotation.async.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.annotation.async.service.ThreadService;

import java.time.LocalDateTime;

@Configuration
public class BootstrapConfiguration {

    @Autowired
    ThreadService service;

    @Bean
    public void syncMethod() {
        // 主线程启动并开启异步线程
        System.out.printf("%s  [%s] syncMethod begin \n",
                LocalDateTime.now(), Thread.currentThread().getName());
        service.asyncMethod();

        // 主线继续执行
        service.sleep(1);
        System.out.printf("%s  [%s] syncMethod doing... \n",
                LocalDateTime.now(), Thread.currentThread().getName());

        // 留住充分时间等待子线程结束
        service.sleep(5);
        System.out.printf("%s  [%s] syncMethod end \n",
                LocalDateTime.now(), Thread.currentThread().getName());
    }
}

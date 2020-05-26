package spring.core.example.service;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;

public class ExitCodeConfiguration {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        System.out.println("ExitCodeGenerator Bean 创建...");
        return () -> {
            System.out.println("执行退出码（88）生成");
            return 88;
        };
    }
}

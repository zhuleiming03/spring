package spring.core.listener.master.listener;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class AutoConfigurationImportEventListener implements AutoConfigurationImportListener {

    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        // 获取当前 ClassLoader
        ClassLoader classLoader = event.getClass().getClassLoader();

        // 候选的自动装配 Class 名单
        List<String> candidates = SpringFactoriesLoader
                .loadFactoryNames(EnableAutoConfiguration.class, classLoader);
        System.out.println(LocalDateTime.now() + "  自动装配候选 Class 名单：");
        candidates.forEach(config -> {
            System.out.printf("%s  %s \n", LocalDateTime.now(), config);
        });

        // 实际的自动装配 Class 名单
        List<String> configurations = event.getCandidateConfigurations();
        System.out.println(LocalDateTime.now() + "  自动装配实际 Class 名单：");
        configurations.forEach(config -> {
            System.out.printf("%s  %s \n", LocalDateTime.now(), config);
        });

        // 排除的自动装配 Class 名单
        Set<String> exclusions = event.getExclusions();
        // 输出各自数量
        System.out.printf("%s  自动装配排除 Class 个数：%d \n",
                LocalDateTime.now(), exclusions.size());
    }
}

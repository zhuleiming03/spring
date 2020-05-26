package spring.core.enable.master.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.core.enable.master.service.AnimalService;

/**
 * 自动装配
 * 扫描指定包下满足条件的 Bean
 */
@ComponentScan(basePackages = "spring.core.enable.master.service.impl")
public class StartByComponentScan {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册引导类（@Configuration 标注）到 Spring 上下文
        context.register(StartByComponentScan.class);
        // 启动上下文
        context.refresh();
        // 获取 AnimalService Bean 对象,实际为 DogServiceImpl
        AnimalService animal = context.getBean(AnimalService.class);
        animal.eat();
        // 关闭上下文
        context.close();
    }
}

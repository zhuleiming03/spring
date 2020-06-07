package spring.core.enable.master.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.enable.master.annotation.EnableImportSelector;
import spring.core.enable.master.domain.Animal;
import spring.core.enable.master.service.AnimalService;

/**
 * 手动装配
 * 基于 “接口编程” 实现 @Enable 模块 ImportSelector
 */
@EnableImportSelector(type = Animal.COW)
public class StartByImportSelector {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册引导类（@Configuration 标注）到 Spring 上下文
        context.register(StartByImportSelector.class);
        // 启动上下文
        context.refresh();
        // 获取 AnimalService Bean 对象,实际为 CowServiceImpl
        AnimalService animal = context.getBean(AnimalService.class);
        animal.eat();
        // 关闭上下文
        context.close();
    }
}

package spring.core.enable.master.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.enable.master.annotation.EnableImportBeanDefinitionRegistrar;
import spring.core.enable.master.domain.Animal;
import spring.core.enable.master.service.impl.LeopardServiceImpl;
import spring.core.enable.master.service.impl.TigerServiceImpl;
import spring.core.enable.master.service.AnimalService;
import spring.core.enable.master.service.impl.LionServiceImpl;

/**
 * 手动装配
 * 基于 “接口编程” 实现 @Enable 模块 ImportBeanDefinitionRegister
 */
@EnableImportBeanDefinitionRegistrar(type = Animal.CAT)
public class StartByImportBeanDefinitionRegistrar {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 注册引导类（@Configuration 标注）到 Spring 上下文
        context.register(StartByImportBeanDefinitionRegistrar.class);
        // 启动上下文
        context.refresh();
        // 获取 AnimalService Bean 对象
        // 实际为 LionServiceImpl TigerServiceImpl LeopardServiceImpl
        AnimalService lion = context.getBean(LionServiceImpl.class);
        AnimalService tiger = context.getBean(TigerServiceImpl.class);
        AnimalService leopard = context.getBean(LeopardServiceImpl.class);
        lion.eat();
        tiger.eat();
        leopard.eat();
        // 关闭上下文
        context.close();
    }

}

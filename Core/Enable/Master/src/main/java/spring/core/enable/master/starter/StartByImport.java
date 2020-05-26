package spring.core.enable.master.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.enable.master.annotation.EnableImport;

/**
 * 手动装配
 * 基于 “注解驱动” 实现 @Enable 模块
 */
@EnableImport
public class StartByImport {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册引导类（@Configuration 标注）到 Spring 上下文
        context.register(StartByImport.class);
        // 启动上下文
        context.refresh();
        // 关闭上下文
        context.close();
    }
}

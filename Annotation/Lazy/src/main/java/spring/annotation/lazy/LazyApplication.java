package spring.annotation.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.lazy.config.BootstrapConfiguration;

public class LazyApplication {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 不执行 register() refresh() 则无法注册 bean helloWorld
        context.register(BootstrapConfiguration.class);
        context.refresh();
        // 调用 Bean cat
        context.getBean("cat");
        // 关闭上下文
        context.close();
    }


}

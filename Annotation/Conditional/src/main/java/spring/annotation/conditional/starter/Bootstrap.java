package spring.annotation.conditional.starter;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotation.conditional.service.AnimalService;

import java.util.Map;
import java.util.stream.Stream;

public class Bootstrap {

    public static void starter(Class<?> configuration) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册当前引导类（@Configuration 标注）到 Spring 上下文
        context.register(configuration);
        // 启动上下文
        context.refresh();
        // 获取 AnimalService Bean 对象
        AnimalService server = context.getBean(AnimalService.class);
        // 输出结果
        System.out.println(server.name());
        // 关闭上下文
        context.close();
    }

    public static void starterByConfiguration(ConfigurableApplicationContext context) {

        // 获取 AnimalService, 来自 AnimalConditionalOnExpression
        Map<String, AnimalService> beans = context.getBeansOfType(AnimalService.class);
        if (beans.isEmpty()) {
            System.out.println("Bean 加载失败");
        } else {
            System.out.println("Bean 加载成功");
        }

        // 显示加载成功的 Bean
        Stream.of(context.getBeanDefinitionNames())
                .sorted().forEach(System.out::println);

        // 关闭当前上下文
        context.close();
    }
}

package spring.annotation.profile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.annotation.profile.service.Animal;

@ComponentScan
public class ProfileApplication {

    public static void main(String[] args) {

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 设置环境变量
        context.getEnvironment().setActiveProfiles("prod");
        // 注册当前引导类（@Configuration 标注）到 Spring 上下文
        context.register(ProfileApplication.class);
        // 启动上下文
        context.refresh();
        // 获取 CalculatingService Bean 对象
        Animal animal = context.getBean(Animal.class);
        // 输出结果
        System.out.println(animal.eat());
        // 关闭上下文
        context.close();
    }
}

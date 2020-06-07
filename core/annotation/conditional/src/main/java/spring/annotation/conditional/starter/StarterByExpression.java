package spring.annotation.conditional.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.annotation.conditional.config.AnimalConditionalOnExpression;

public class StarterByExpression {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new
                SpringApplicationBuilder(AnimalConditionalOnExpression.class)
                .web(WebApplicationType.NONE)
                // 只有在 .properties("env.expression=true") 下才能加载成功
                .properties("env.expression=true")
                .run(args);

        Bootstrap.starterByConfiguration(context);
    }
}

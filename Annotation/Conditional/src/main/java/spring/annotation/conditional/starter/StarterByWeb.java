package spring.annotation.conditional.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import spring.annotation.conditional.config.AnimalConditionalOnWeb;


public class StarterByWeb {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new
                SpringApplicationBuilder(AnimalConditionalOnWeb.class)
                // 只有在 WebApplicationType.SERVLET 下才能加载成功
                .web(WebApplicationType.SERVLET)
                .run(args);

        Bootstrap.starterByConfiguration(context);
    }
}

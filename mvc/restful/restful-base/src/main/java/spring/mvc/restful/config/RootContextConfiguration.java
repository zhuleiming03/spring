package spring.mvc.restful.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "spring.mvc.restful",
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootContextConfiguration {
    RootContextConfiguration() {
        System.out.println("Class RootContextConfiguration init");
    }


}

package spring.mvc.restful.config;

import spring.mvc.restful.annotation.WebController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(
        basePackages = "spring.mvc.restful",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(WebController.class)
)
public class WebServletContextConfiguration {
    public WebServletContextConfiguration() {
        System.out.println("Class WebServletContextConfiguration init");
    }
}


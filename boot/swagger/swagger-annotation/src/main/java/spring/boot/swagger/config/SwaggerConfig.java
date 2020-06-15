package spring.boot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("spring.boot.swagger.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .globalOperationParameters(buildCommonHeader());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("Yapi 数据导入 url: http://localhost:8080/v2/api-docs")
                .version("1.0.0")
                .build();
    }

    private List<Parameter> buildCommonHeader() {
        List<Parameter> parameters = new ArrayList<>();
        Parameter outer = new ParameterBuilder()
                .name("user")
                .description("user token (optional)")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(outer);
        return parameters;
    }
}

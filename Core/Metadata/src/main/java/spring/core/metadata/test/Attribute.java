package spring.core.metadata.test;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.core.metadata.annotation.Demo;

import java.lang.reflect.AnnotatedElement;

@Demo(name = "attribute", value = "demo")
public class Attribute {

    public static void main(String[] args) {

        AnnotatedElement annotatedElement = Attribute.class;

        // @Component 被 @Service 隐性覆盖了
        // 显性覆盖请参考 @AliasFor
        AnnotationAttributes componet = AnnotatedElementUtils
                .getMergedAnnotationAttributes(annotatedElement, Component.class);
        print(componet);

        AnnotationAttributes service = AnnotatedElementUtils
                .getMergedAnnotationAttributes(annotatedElement, Service.class);
        print(service);

        AnnotationAttributes demo = AnnotatedElementUtils
                .getMergedAnnotationAttributes(annotatedElement, Demo.class);
        print(demo);
    }

    private static void print(AnnotationAttributes annotationAttributes) {

        System.out.printf("注解 @%s 属性集合： \n"
                , annotationAttributes.annotationType().getName());

        annotationAttributes.forEach((name, value) ->
                System.out.printf("\t 属性 %s : %s \n", name, value));
    }
}

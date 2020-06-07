package spring.annotation.aliasfor.test;

import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import spring.annotation.aliasfor.annotation.DemoTwo;
import spring.annotation.aliasfor.domain.InstanceThree;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Import(DemoTwo.class)
public class TestTwo {

    public static void main(String[] args) {

        System.out.println("--------- 多个注解使用 @AliasFor -------");

        SimpleMetadataReaderFactory metadataReaderFactory =
                new SimpleMetadataReaderFactory();
        try {
            AnnotationMetadata annotationMetadata = metadataReaderFactory
                    .getMetadataReader(InstanceThree.class.getName())
                    .getAnnotationMetadata();

            annotationMetadata.getAnnotationTypes().forEach(annotationType -> {
                Map<String, Object> methods = annotationMetadata.getAnnotationAttributes(annotationType);
                if (!CollectionUtils.isEmpty(methods)) {
                    methods.forEach((k, v) -> System.out.printf("注解 @%s %s = %s\n",
                            ClassUtils.getShortName(annotationType), k, convert(v)));
                }
            });

            Set<String> metaAnnotationTypeSet = annotationMetadata.getAnnotationTypes()
                    .stream()
                    .map(annotationType -> annotationMetadata.getMetaAnnotationTypes(annotationType))
                    .collect(LinkedHashSet::new, Set::addAll, Set::addAll);

            metaAnnotationTypeSet.forEach(annotationType -> {
                Map<String, Object> methods = annotationMetadata.getAnnotationAttributes(annotationType);
                if (!CollectionUtils.isEmpty(methods)) {
                    methods.forEach((k, v) -> System.out.printf("元注解 @%s %s = %s\n",
                            ClassUtils.getShortName(annotationType), k, convert(v)));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convert(Object object) {
        if (object instanceof String) {
            return object.toString();
        } else if (object instanceof String[]) {
            StringBuilder builder = new StringBuilder();
            for (String item : (String[]) object) {
                builder.append(item);
                builder.append(" ");
            }
            return builder.toString();
        } else {
            return "";
        }
    }
}

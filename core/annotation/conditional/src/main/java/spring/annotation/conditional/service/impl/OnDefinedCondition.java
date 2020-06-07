package spring.annotation.conditional.service.impl;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;
import spring.annotation.conditional.annotation.ConditionalOnDefined;


public class OnDefinedCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 获取 ConditionalOnDefined 所有的属性方法值
        MultiValueMap<String, Object> attributes =
                metadata.getAllAnnotationAttributes(ConditionalOnDefined.class.getName());
        // 获取 ConditionalOnDefined#key() 方法值（单值）
        String propertyKey = (String) attributes.getFirst("key");
        // 获取 ConditionalOnDefined#value() 方法值（单值）
        String propertyValue = (String) attributes.getFirst("value");
        // 可以实现自定义的业务逻辑实现返回 true or false
        System.out.printf("注解 @ConditionalOnDefined, key:%s  , value: %s \n",
                propertyKey, propertyValue);
        return true;
    }
}

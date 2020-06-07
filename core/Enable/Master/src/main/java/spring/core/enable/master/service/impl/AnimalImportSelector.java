package spring.core.enable.master.service.impl;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import spring.core.enable.master.annotation.EnableImportSelector;
import spring.core.enable.master.domain.Animal;

import java.util.Map;

public class AnimalImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 读取 EnableServer 中所有的属性方法，本例仅有 type() 属性方法
        // 其中 Key 为属性方法的名称, value 为属性方法的返回对象
        Map<String, Object> annotationAttributes =
                importingClassMetadata.getAnnotationAttributes(EnableImportSelector.class.getName());
        return getImportClassNames(annotationAttributes);
    }

    public static String[] getImportClassNames(Map<String, Object> annotationAttributes) {
        // 获取名为 "type" 的属性方法, 并且强制转化成 Animal 类型
        Animal type = (Animal) annotationAttributes.get("type");
        // 导入的类名称数组
        String[] importClassNames = new String[0];
        switch (type) {
            case CAT:
                importClassNames = new String[]{
                        LionServiceImpl.class.getName(),
                        TigerServiceImpl.class.getName(),
                        LeopardServiceImpl.class.getName()};
                break;
            case COW:
                importClassNames = new String[]{CowServiceImpl.class.getName()};
                break;
            case DOG:
                importClassNames = new String[]{DogServiceImpl.class.getName()};
                break;
            default:
                importClassNames = new String[]{CatServiceImpl.class.getName()};
                break;
        }
        return importClassNames;
    }
}

package spring.core.metadata.test;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import spring.core.metadata.annotation.Demo;
import spring.core.metadata.service.AsmService;

import java.io.IOException;
//import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;

@Demo(name = "test")
public class MetadataByAsm {

    public static void main(String[] args) throws IOException {

        // 构造 MetadataReaderFactory 实例
        // CachingMetadataReaderFactory extends SimpleMetadataReaderFactory
        // MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();

        // 读取 ASM 的 MetadataReader 信息
        MetadataReader metadataReader = metadataReaderFactory
                .getMetadataReader(MetadataByAsm.class.getName());

        // 注解的元信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // ASM 方式读取
        // AnnotationMetadataReadingVisitor(过时) 用 SimpleAnnotationMetadataReadingVisitor 替换
        //AnnotationMetadata annotationMetadata = new AnnotationMetadataReadingVisitor(ClassLoader.getSystemClassLoader());
        // StandardAnnotationMetadata java 反射方式读取
        //AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(MetadataByAsm.class);
        AsmService.printAnnotationMetadata(annotationMetadata);

        // 类的资源信息
        Resource resource = metadataReader.getResource();
        AsmService.printResource(resource);

        // 类的元信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
    }
}

package spring.annotation.primary.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring.annotation.primary.service.Animal;

/**
 * 存在多个实例实现接口 Animal 则优先加载该实例
 */
@Primary
@Service
public class Cat implements Animal {

    @Override
    public void eat(){
        System.out.println("cat eat fish");
    }
}

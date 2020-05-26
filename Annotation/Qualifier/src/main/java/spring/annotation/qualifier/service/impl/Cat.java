package spring.annotation.qualifier.service.impl;

import org.springframework.stereotype.Service;
import spring.annotation.qualifier.service.Animal;

@Service("cat")
public class Cat implements Animal {

    @Override
    public void eat(){
        System.out.println("cat eat fish");
    }
}

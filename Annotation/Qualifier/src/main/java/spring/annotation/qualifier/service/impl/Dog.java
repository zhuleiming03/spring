package spring.annotation.qualifier.service.impl;

import org.springframework.stereotype.Service;
import spring.annotation.qualifier.service.Animal;

@Service("dog")
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("Dog eat bone");
    }
}

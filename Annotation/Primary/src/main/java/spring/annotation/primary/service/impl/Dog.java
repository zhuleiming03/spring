package spring.annotation.primary.service.impl;

import org.springframework.stereotype.Service;
import spring.annotation.primary.service.Animal;

@Service
public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("Dog eat bone");
    }
}

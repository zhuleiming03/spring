package spring.annotation.profile.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import spring.annotation.profile.service.Animal;

@Component
@Profile("dev")
public class Dog implements Animal {

    @Override
    public String eat(){
        return "Dog eat bone";
    }
}

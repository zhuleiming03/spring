package spring.core.enable.master.service.impl;

import org.springframework.stereotype.Component;
import spring.core.enable.master.service.AnimalService;

@Component("spring.core.enable.master.service.impl.DogService")
public class DogServiceImpl implements AnimalService {

    @Override
    public void eat() {
        System.out.println("dog eat bone");
    }
}

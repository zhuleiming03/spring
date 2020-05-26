package spring.core.enable.master.service.impl;

import spring.core.enable.master.service.AnimalService;

public class CowServiceImpl implements AnimalService {

    @Override
    public void eat() {
        System.out.println("cow eat grass");
    }
}

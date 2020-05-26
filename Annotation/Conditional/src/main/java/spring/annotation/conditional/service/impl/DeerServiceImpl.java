package spring.annotation.conditional.service.impl;

import spring.annotation.conditional.service.AnimalService;

public class DeerServiceImpl implements AnimalService {

    @Override
    public String name() {
        return "This is a deer";
    }
}

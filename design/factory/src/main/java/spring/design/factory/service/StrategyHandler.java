package spring.design.factory.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StrategyHandler {

    @Resource
    FactoryForStrategy factory;

    public void choose(String type) {
        Strategy strategy = factory.getStrategy(type);
        System.out.println(strategy.doOperation());
    }

}

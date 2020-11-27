package spring.design.factory.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FactoryForStrategy {

    @Resource
    Map<String, Strategy> strategies = new ConcurrentHashMap<>(3);

    public Strategy getStrategy(String component) {
        Strategy strategy = strategies.get(component);
        if (strategy == null) {
            throw new RuntimeException("no strategy defined");
        }
        return strategy;
    }

}

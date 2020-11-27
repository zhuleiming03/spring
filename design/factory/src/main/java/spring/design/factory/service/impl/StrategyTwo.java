package spring.design.factory.service.impl;

import org.springframework.stereotype.Component;
import spring.design.factory.service.Strategy;

@Component("two")
public class StrategyTwo implements Strategy {

    @Override
    public String doOperation() {
        return "Strategy Two";
    }
}

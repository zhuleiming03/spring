package spring.design.factory.service.impl;

import org.springframework.stereotype.Component;
import spring.design.factory.service.Strategy;

@Component("one")
public class StrategyOne implements Strategy {

    @Override
    public String doOperation() {
        return "Strategy One";
    }
}

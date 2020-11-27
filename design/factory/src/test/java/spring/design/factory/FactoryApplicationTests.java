package spring.design.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.design.factory.service.StrategyHandler;

@SpringBootTest
class FactoryApplicationTests {

    @Test
    void contextLoads() {
        strategyHandler.choose("two");
        strategyHandler.choose("one");
    }

    @Autowired
    private StrategyHandler strategyHandler;

}

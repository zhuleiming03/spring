package spring.core.enable.master.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.enable.master.service.AnimalService;

/**
 * spring framework 3.1 后可不要 @Configuration
 */
//@Configuration
public class CatServiceImpl implements AnimalService {

    @Bean("spring.core.enable.master.service.impl.CatServiceImpl.eat")
    @Override
    public void eat() {
        System.out.println("cat eat fish");
    }
}

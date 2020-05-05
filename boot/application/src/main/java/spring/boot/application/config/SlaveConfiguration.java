package spring.boot.application.config;

import spring.boot.application.annotation.DefinedService;

@DefinedService
public class SlaveConfiguration {

    public SlaveConfiguration() {
        System.out.println("Bean slaveConfiguration create");
    }
}

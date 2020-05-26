package spring.core.enable.slave.domain;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;

@AutoConfigureBefore(Chicken.class)
public class Duck {
}

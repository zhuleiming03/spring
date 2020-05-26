package spring.annotation.conditional.starter;

import spring.annotation.conditional.config.AnimalConditionalOnClass;

public class StarterByClass {

    public static void main(String[] args) {
        Bootstrap.starter(AnimalConditionalOnClass.class);
    }
}

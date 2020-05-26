package spring.annotation.conditional.starter;

import spring.annotation.conditional.config.AnimalConditionalOnDefined;

public class StarterByDefined {
    public static void main(String[] args) {
        Bootstrap.starter(AnimalConditionalOnDefined.class);
    }
}

package spring.annotation.conditional.starter;

import spring.annotation.conditional.config.AnimalConditionalOnResource;

public class StarterByResource {

    public static void main(String[] args) {
        Bootstrap.starter(AnimalConditionalOnResource.class);
    }
}

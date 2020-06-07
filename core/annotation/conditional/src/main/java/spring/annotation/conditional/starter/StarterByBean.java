package spring.annotation.conditional.starter;

import spring.annotation.conditional.config.AnimalConditionalOnBean;

public class StarterByBean {

    public static void main(String[] args) {
        Bootstrap.starter(AnimalConditionalOnBean.class);
    }
}

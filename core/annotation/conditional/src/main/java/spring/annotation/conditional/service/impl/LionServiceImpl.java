package spring.annotation.conditional.service.impl;

public class LionServiceImpl extends CatServiceImpl {

    @Override
    public String name() {
        return "This is a Lion";
    }
}

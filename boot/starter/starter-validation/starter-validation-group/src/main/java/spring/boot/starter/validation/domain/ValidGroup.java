package spring.boot.starter.validation.domain;

import javax.validation.groups.Default;

public class ValidGroup {

    public interface QueryType extends Default {
    }

    public interface AlterType extends Default {
    }
}

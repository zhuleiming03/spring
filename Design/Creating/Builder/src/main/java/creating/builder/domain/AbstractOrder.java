package creating.builder.domain;

import java.util.List;

public abstract class AbstractOrder {

    protected List<AbstractCompany> company;

    protected AbstractProduct orderSource;

    protected AbstractUser user;

    protected AbstractProduct product;
}

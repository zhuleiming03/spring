package creating.builder.domain;

import creating.builder.domain.Order.Order;

public abstract class AbstractOrderBuilder {

    protected Order order = new Order();

    public abstract void buildCompany();

    public abstract void buildProduct();

    public abstract void buildUser();

    public AbstractOrder getOrder() {
        return order;
    }
}

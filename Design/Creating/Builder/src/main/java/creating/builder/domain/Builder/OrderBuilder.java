package creating.builder.domain.Builder;

import creating.builder.domain.AbstractOrder;
import creating.builder.domain.AbstractOrderBuilder;

public class OrderBuilder {

    private AbstractOrderBuilder builder;

    public OrderBuilder(AbstractOrderBuilder builder) {
        this.builder = builder;
    }

    public AbstractOrder construct() {
        builder.buildCompany();
        builder.buildProduct();
        builder.buildUser();
        return builder.getOrder();
    }
}

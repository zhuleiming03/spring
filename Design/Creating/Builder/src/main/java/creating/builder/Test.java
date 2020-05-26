package creating.builder;

import creating.builder.domain.AbstractOrder;
import creating.builder.domain.AbstractOrderBuilder;
import creating.builder.domain.Builder.OrderBuilder;
import creating.builder.domain.OrderBuilder.SurfingOrderBuilder;

public class Test {

    public static void main(String[] args) {

        AbstractOrderBuilder surfingOrderBuilder = new SurfingOrderBuilder();
        OrderBuilder orderBuilder = new OrderBuilder(surfingOrderBuilder);
        AbstractOrder order = orderBuilder.construct();
        System.out.println(order);

    }
}

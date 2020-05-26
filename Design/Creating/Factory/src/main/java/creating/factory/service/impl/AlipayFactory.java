package creating.factory.service.impl;

import creating.factory.service.PaymentAbstractFactory;
import creating.factory.service.PaymentService;

public class AlipayFactory implements PaymentAbstractFactory {

    @Override
    public PaymentService getPaymentInstance() {
        return new AlipayServiceImpl();
    }
}

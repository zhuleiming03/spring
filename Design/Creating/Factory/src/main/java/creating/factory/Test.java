package creating.factory;

import creating.factory.service.PaymentAbstractFactory;
import creating.factory.service.PaymentService;
import creating.factory.service.ReadXML;

public class Test {

    public static void main(String[] args) {
        try {
            PaymentAbstractFactory paymentAbstractFactory = (PaymentAbstractFactory) ReadXML.getObject();
            if (paymentAbstractFactory != null) {
                PaymentService service = paymentAbstractFactory.getPaymentInstance();
                service.deduct();
                service.query();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

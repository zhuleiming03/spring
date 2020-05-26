package creating.factory.service.impl;

import creating.factory.service.PaymentService;

public class AlipayServiceImpl implements PaymentService {

    @Override
    public void deduct() {
        System.out.println("支付宝发起扣款");
    }

    @Override
    public void query() {
        System.out.println("支付宝查询扣款结果");
    }
}

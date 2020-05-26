package creating.factory.service.impl;

import creating.factory.service.PaymentService;

public class TenpayServiceImpl implements PaymentService {

    @Override
    public void deduct() {
        System.out.println("财富通发起扣款");
    }

    @Override
    public void query() {
        System.out.println("财富通查询扣款结果");
    }
}

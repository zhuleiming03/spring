package structural.decorator.service.impl;

import structural.decorator.service.BillService;

public class BillServiceDecoratorImpl extends BillServiceDecorator {

    public BillServiceDecoratorImpl(BillService billService) {
        super(billService);
    }

    @Override
    public void billChange() {
        super.billChange();
        System.out.println("bill extend dealing...");
    }
}

package structural.decorator.service.impl;

import structural.decorator.service.BillService;

public class BillServiceDecorator implements BillService {

    private BillService billService;

    public BillServiceDecorator(BillService billService) {
        this.billService = billService;
    }

    @Override
    public void billChange() {
        this.billService.billChange();
    }
}

package structural.decorator.service.impl;

import structural.decorator.service.BillService;

public class BillServiceImpl implements BillService {

    @Override
    public void billChange() {
        System.out.println("bill dealing...");
    }
}

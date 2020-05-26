package structural.proxy.service.impl;

import structural.proxy.service.BillService;

public class BillServiceProxy implements BillService {

    private BillServiceImpl billService;

    private void before() {
        System.out.println("freeze up bill");
    }

    private void after() {
        System.out.println("unfreeze bill");
    }

    @Override
    public void billChange() {
        if (this.billService == null) {
            this.billService = new BillServiceImpl();
        }

        before();
        this.billService.billChange();
        after();
    }
}

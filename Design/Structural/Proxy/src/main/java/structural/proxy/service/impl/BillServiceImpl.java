package structural.proxy.service.impl;

import structural.proxy.service.BillService;

public class BillServiceImpl implements BillService {

    @Override
    public void billChange() {
        System.out.println("bill dealing...");
    }
}

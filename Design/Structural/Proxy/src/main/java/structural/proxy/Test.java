package structural.proxy;

import structural.proxy.service.BillService;
import structural.proxy.service.impl.BillServiceImpl;
import structural.proxy.service.impl.BillServiceProxy;

public class Test {

    public static void main(String[] args) {

        System.out.println("---------- 正常账单处理 --------------");
        BillService commonBillService = new BillServiceImpl();
        commonBillService.billChange();

        System.out.println("---------- 代理账单处理 --------------");
        BillService proxyBillService = new BillServiceProxy();
        proxyBillService.billChange();
    }
}

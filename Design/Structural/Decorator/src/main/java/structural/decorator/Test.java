package structural.decorator;

import structural.decorator.service.BillService;
import structural.decorator.service.impl.BillServiceDecoratorImpl;
import structural.decorator.service.impl.BillServiceImpl;

public class Test {

    public static void main(String[] args) {

        System.out.println("---------- 正常账单处理 --------------");
        BillService commonBillService = new BillServiceImpl();
        commonBillService.billChange();

        System.out.println("---------- 装饰账单处理 --------------");
        BillService decordtorBillService = new BillServiceDecoratorImpl(commonBillService);
        decordtorBillService.billChange();
    }
}

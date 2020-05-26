package structural.adapter;

import structural.adapter.adapter.BillAdapter;
import structural.adapter.adapter.SurfingBillAdapter;
import structural.adapter.common.BillService;
import structural.adapter.special.SurfingBillService;

public class Test {

    public static void main(String[] args) {

        // 类适配器模式
        SurfingBillService surfingBillServiceOne = new BillAdapter();
        surfingBillServiceOne.generate();

        //对象适配器模式
        BillService billService = new BillService();
        SurfingBillService surfingBillServiceTwo = new SurfingBillAdapter(billService);
        surfingBillServiceTwo.generate();
    }
}

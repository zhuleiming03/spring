package structural.composite;

import structural.composite.domain.Bill;
import structural.composite.domain.BillItem;

public class Test {

    public static void main(String[] args) {

        BillItem billItem;
        Bill bill;

        bill = new Bill(1);
        billItem = new BillItem("本金", 1000, 3000);
        bill.add(billItem);
        billItem = new BillItem("利息", 100, 1300);
        bill.add(billItem);
        billItem = new BillItem("罚息", 100, 100);
        bill.add(billItem);
        billItem = new BillItem("担保费", 100, 300);
        bill.add(billItem);
        bill.show();

        bill = new Bill(2);
        billItem = new BillItem("本金", 10000, 12000);
        bill.add(billItem);
        billItem = new BillItem("利息", 299, 300);
        bill.add(billItem);
        billItem = new BillItem("减免", 10, 0);
        bill.add(billItem);
        bill.show();
    }

}

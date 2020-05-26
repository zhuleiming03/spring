package structural.composite.domain;

import java.util.ArrayList;

public class Bill implements IBillItem {

    private Integer index;
    private ArrayList<BillItem> billItems = new ArrayList<BillItem>();

    public Bill(Integer index) {
        this.index = index;
    }

    public void add(BillItem billItem) {
        billItems.add(billItem);
    }

    public void remove(BillItem billItem) {
        billItems.remove(billItem);
    }

    public BillItem getChild(int i) {
        return billItems.get(i);
    }

    @Override
    public float calculation() {
        float s = 0;
        for (BillItem obj : this.billItems) {
            s = s + obj.calculation();
        }
        return s;
    }

    @Override
    public void show() {
        System.out.printf("第%2d 期账单总金额：%s ,详情：\n",
                this.index, calculation());
        for (BillItem obj : this.billItems) {
            obj.show();
        }
    }
}

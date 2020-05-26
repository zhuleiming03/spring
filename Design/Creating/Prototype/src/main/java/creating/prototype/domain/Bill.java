package creating.prototype.domain;

import java.util.LinkedList;
import java.util.List;

public class Bill implements Cloneable {

    private Float amount;

    private List<BillItem> billItems;

    public Bill() {
        this.billItems = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "amount=" + amount +
                ", billItems=" + billItems +
                '}';
    }

    @Override
    public Bill clone() {
        try {
            Bill bill = (Bill) super.clone();
            // billItems 属于List 如果不重新 new 则取的还是原来的 LinkedList
            bill.billItems = new LinkedList<>();
            for (BillItem item : this.billItems) {
                bill.billItems.add(item.clone());
            }
            return bill;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }


}

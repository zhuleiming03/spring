package creating.prototype.service;

import creating.prototype.domain.Bill;
import creating.prototype.domain.BillItem;

public class BillService {

    public Bill overDayMath(Bill bill) {
        Bill overBill = bill.clone();
        BillItem interestItem =
                new BillItem(23, bill.getAmount() * 0.01f);
        overBill.getBillItems().add(interestItem);
        overBill.setAmount(overBill.getAmount() + interestItem.getAmount());
        return overBill;
    }

    public Bill remittedMath(Bill bill) {
        Bill remittedBill = bill.clone();
        remittedBill.getBillItems()
                .forEach(item -> item.setAmount(item.getAmount() * 0.8f));
        remittedBill.setAmount(remittedBill.getAmount() * 0.8f);
        return remittedBill;
    }
}

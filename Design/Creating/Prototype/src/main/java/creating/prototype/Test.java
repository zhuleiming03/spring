package creating.prototype;

import creating.prototype.domain.Bill;
import creating.prototype.domain.BillItem;
import creating.prototype.service.BillService;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // 初始化账单信息
        Bill bill = new Bill();
        List<BillItem> billItems = new LinkedList<>();
        BillItem principalItem = new BillItem(1, 10000f);
        billItems.add(principalItem);
        BillItem guaranteeItem = new BillItem(3, 500f);
        billItems.add(guaranteeItem);
        bill.setAmount(10500f);
        bill.setBillItems(billItems);
        System.out.println("初始账单：" + bill);

        BillService service = new BillService();

        // 逾期计算
        System.out.println("逾期账单：" + service.overDayMath(bill));

        // 优惠计算
        System.out.println("优惠账单：" + service.remittedMath(bill));

        System.out.println("原始账单：" + bill);
    }
}

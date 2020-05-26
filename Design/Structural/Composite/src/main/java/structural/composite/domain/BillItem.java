package structural.composite.domain;

public class BillItem implements IBillItem {

    private String name;

    private float receive;

    private float amount;

    public BillItem(String name, float receive, float amount) {
        this.name = name;
        this.receive = receive;
        this.amount = amount;
    }

    @Override
    public float calculation() {
        return amount - receive;
    }

    @Override
    public void show() {
        System.out.printf("科目：%s ,逾期金额：%s\n",
                this.name, calculation());
    }
}

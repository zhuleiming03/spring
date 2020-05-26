package creating.prototype.domain;

public class BillItem implements Cloneable {

    private Integer subject;

    private Float amount;

    public BillItem(){}

    @Override
    public String toString() {
        return "BillItem{" +
                "subject=" + subject +
                ", amount=" + amount +
                '}';
    }

    @Override
    public BillItem clone() {
        try {
            return (BillItem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public BillItem(Integer subject, Float amount) {
        this.subject = subject;
        this.amount = amount;
    }
}

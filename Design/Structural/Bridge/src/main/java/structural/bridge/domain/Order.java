package structural.bridge.domain;

public class Order extends AbstractOrder {

    private Float amount;

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", user=" + user +
                '}';
    }

    public Order(IUser user) {
        this.user = user;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}

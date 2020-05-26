package creating.builder.domain.Order;

import creating.builder.domain.AbstractCompany;
import creating.builder.domain.AbstractOrder;
import creating.builder.domain.AbstractProduct;
import creating.builder.domain.AbstractUser;

import java.util.List;

public class Order extends AbstractOrder {

    @Override
    public String toString() {
        return "Order{" +
                "company=" + company +
                ", orderSource=" + orderSource +
                ", user=" + user +
                ", product=" + product +
                '}';
    }

    public List<AbstractCompany> getCompany() {
        return company;
    }

    public void setCompany(List<AbstractCompany> company) {
        this.company = company;
    }

    public AbstractProduct getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(AbstractProduct orderSource) {
        this.orderSource = orderSource;
    }

    public AbstractUser getUser() {
        return user;
    }

    public void setUser(AbstractUser user) {
        this.user = user;
    }

    public AbstractProduct getProduct() {
        return product;
    }

    public void setProduct(AbstractProduct product) {
        this.product = product;
    }

}

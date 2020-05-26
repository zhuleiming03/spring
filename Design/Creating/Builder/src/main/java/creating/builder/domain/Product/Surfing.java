package creating.builder.domain.Product;

import creating.builder.domain.AbstractCompany;
import creating.builder.domain.AbstractProduct;

public class Surfing extends AbstractProduct {

    public AbstractCompany company;

    @Override
    public String toString() {
        return "Surfing{" +
                "company=" + company +
                '}';
    }

    public AbstractCompany getCompany() {
        return company;
    }

    public void setCompany(AbstractCompany company) {
        this.company = company;
    }
}

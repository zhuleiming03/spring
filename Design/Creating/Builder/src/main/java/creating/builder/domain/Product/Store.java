package creating.builder.domain.Product;

import creating.builder.domain.AbstractProduct;

public class Store extends AbstractProduct {

    public String region;

    @Override
    public String toString() {
        return "Store{" +
                "region='" + region + '\'' +
                '}';
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

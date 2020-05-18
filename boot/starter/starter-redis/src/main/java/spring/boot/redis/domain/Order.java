package spring.boot.redis.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {

    private Integer id;

    private String product;

    private Map<Integer, Bill> bills;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", bills=" + bills +
                '}';
    }

    public Order(Integer id, String product) {
        this(id, product, new HashMap<>(0));
    }

    public Order(Integer id, String product, Map<Integer, Bill> maps) {
        this.id = id;
        this.product = product;
        this.bills = maps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Map<Integer, Bill> getBills() {
        return bills;
    }

    public void setBills(Map<Integer, Bill> bills) {
        this.bills = bills;
    }
}

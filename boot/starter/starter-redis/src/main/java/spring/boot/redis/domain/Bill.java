package spring.boot.redis.domain;

import java.io.Serializable;
import java.util.List;

public class Bill implements Serializable {

    private Integer period;

    private List<Item> items;

    public Bill() {
    }

    public Bill(Integer period, List<Item> items) {
        this.period = period;
        this.items = items;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

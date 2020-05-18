package spring.boot.redis.domain;

import java.io.Serializable;

public class Item implements Serializable {

    private Integer subject;

    private Float amount;

    public Item() {
    }

    public Item(Integer subject, Float amount) {
        this.subject = subject;
        this.amount = amount;
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
}

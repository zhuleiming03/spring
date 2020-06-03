package spring.boot.starter.validation.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    @Digits(integer = 2, fraction = 0)
    private Integer id;

    @NotNull
    private String context;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", context='" + context + '\'' +
                '}';
    }

    public Message() {
    }

    public Message(Integer id, String context) {
        this.id = id;
        this.context = context;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

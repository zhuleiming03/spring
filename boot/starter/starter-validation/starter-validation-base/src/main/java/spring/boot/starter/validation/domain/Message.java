package spring.boot.starter.validation.domain;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    private Integer id;

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

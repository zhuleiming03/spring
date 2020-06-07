package spring.mvc.restful.domain;


public class JsonMessage {

    private Long id;

    private String info;

    private String href;

    @Override
    public String toString() {
        return "JsonMessage{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", href='" + href + '\'' +
                '}';
    }

    public JsonMessage() {
    }

    public JsonMessage(Long id, String info, String href) {
        this.id = id;
        this.info = info;
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}

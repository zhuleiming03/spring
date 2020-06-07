package spring.mvc.restful.domain;

public class Form {

    private Long userId;

    @Override
    public String toString() {
        return "Form{" +
                "userId=" + userId +
                '}';
    }

    public Form() {
    }

    public Form(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

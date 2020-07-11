package spring.boot.starter.web.rest.domain;

public class User {

    private Integer id;

    private String name;

    private Float rebate;

    public User() {
    }

    public User(Integer id, String name, Float rebate) {
        this.id = id;
        this.name = name;
        this.rebate = rebate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRebate() {
        return rebate;
    }

    public void setRebate(Float rebate) {
        this.rebate = rebate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rebate=" + rebate +
                '}';
    }
}

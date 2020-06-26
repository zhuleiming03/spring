package spring.boot.data.mybatis.enums;

public enum SexEnum {
    /**
     * 男
     */
    MALE("MALE"),
    /**
     * 女
     */
    FEMALE("FEMALE"),
    /**
     * 其他
     */
    OTHER("OTHER");

    private String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex() {
        this.sex = sex;
    }
}

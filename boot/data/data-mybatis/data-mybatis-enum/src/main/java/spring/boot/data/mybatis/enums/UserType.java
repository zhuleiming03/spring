package spring.boot.data.mybatis.enums;

public enum UserType {

    /**
     * 默认
     */
    DEFAULT(0),
    /**
     * 老师
     */
    TEACHER(1),
    /**
     * 学生
     */
    STUDENT(2);

    private Integer type;

    UserType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static UserType valueOf(Integer code) {
        if (code != null) {
            for (UserType enumInstance : UserType.values()) {
                if (enumInstance.getType().equals(code)) {
                    return enumInstance;
                }
            }
        }
        return UserType.DEFAULT;
    }
}

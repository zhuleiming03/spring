package spring.boot.data.mybatis.enums;

public enum LevelEnum {

    /**
     * 青铜
     */
    Copper(1),
    /**
     * 白银
     */
    Silver(2),
    /**
     * 黄金
     */
    Gold(3);

    private Integer code;

    LevelEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static LevelEnum valueOf(Integer code) {
        for (LevelEnum enumInstance : LevelEnum.values()) {
            if (code.equals(enumInstance.getCode())) {
                return enumInstance;
            }
        }
        return null;
    }
}

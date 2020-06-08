package spring.boot.data.mybatis.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Users {
    /**
    * 主键id
    */
    private Long id;

    /**
    * 姓名
    */
    private String userName;

    /**
    * 年龄
    */
    private Short age;

    /**
    * 折扣
    */
    private Double cheapRate;

    /**
    * 余额
    */
    private BigDecimal balance;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 是否有效（1：是；0：否）
    */
    private Byte isValid;
}
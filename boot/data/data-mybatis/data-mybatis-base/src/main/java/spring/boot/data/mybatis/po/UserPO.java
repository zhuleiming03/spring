package spring.boot.data.mybatis.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserPO {
    private Long id;
    private String name;
    private Short age;
    private Double cheapRate;
    private BigDecimal balance;
    private Timestamp createTime;
    private LocalDateTime updateTime;
    private Boolean vaild;
}

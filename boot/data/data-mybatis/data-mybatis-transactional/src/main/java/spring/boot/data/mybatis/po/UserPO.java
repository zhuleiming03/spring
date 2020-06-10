package spring.boot.data.mybatis.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class UserPO {
    private Long id;
    private String name;
    private BigDecimal balance;
    private Timestamp createTime;
    private LocalDateTime updateTime;
    private Boolean vaild;

    public UserPO(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createTime = (new Timestamp(System.currentTimeMillis()));
        this.updateTime = LocalDateTime.now();
        this.vaild = true;
    }
}

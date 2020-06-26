package spring.boot.data.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.boot.data.mybatis.enums.SexEnum;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPO {

    private Integer userId;

    private Long cardNo;

    private String loginName;

    private Short level;

    private SexEnum sex;

    private Float cheapRate;

    private BigDecimal balance;

    private LocalDate lastUseTime;

    private Timestamp crateTime;

    private Boolean valid;
}

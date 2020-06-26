package spring.boot.data.mybatis.vo;

import lombok.Data;
import spring.boot.data.mybatis.enums.LevelEnum;
import spring.boot.data.mybatis.enums.SexEnum;

import java.time.LocalDate;

@Data
public class CustomerVO {

    private Integer id;

    private Long cardNo;

    private String name;

    private LevelEnum level;

    private SexEnum sex;

    private Short age;

    private Float cheapRate;

    private LocalDate lastUseTime;
}

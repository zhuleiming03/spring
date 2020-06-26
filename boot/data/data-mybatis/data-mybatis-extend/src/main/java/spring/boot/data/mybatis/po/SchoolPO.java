package spring.boot.data.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class SchoolPO {

    private Integer schoolId;

    private String schoolName;
}

package spring.boot.data.mybatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherPO {

    private Integer id;

    private String course;

    private Integer school;
}

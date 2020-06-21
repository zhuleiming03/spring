package spring.boot.data.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TeacherPO {

    private Integer id;

    private String course;

    private SchoolPO schoolPo;

    private List<StudentPO> students;
}

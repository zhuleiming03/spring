package spring.boot.data.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TeacherPO {

    private Integer teacherId;

    private String name;

    private SchoolPO schoolPo;

    private List<ClassPO> classes;

    public TeacherPO(Integer teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }
}

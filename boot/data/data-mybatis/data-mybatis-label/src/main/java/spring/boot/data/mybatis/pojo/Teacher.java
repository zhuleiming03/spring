package spring.boot.data.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer id;

    private String level;

    private Integer schoolId;

    private School school;

    private List<Student> students;
}

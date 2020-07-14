package spring.boot.data.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student  {

    private Integer id;

    private String family;

    private Integer teacherId;
}

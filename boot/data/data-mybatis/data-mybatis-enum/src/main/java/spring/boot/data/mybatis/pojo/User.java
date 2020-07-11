package spring.boot.data.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.boot.data.mybatis.enums.Gender;
import spring.boot.data.mybatis.enums.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private UserType type;

    private Gender gender;
}

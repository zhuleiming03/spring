package spring.boot.data.mybatis.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Timestamp birthday;
}

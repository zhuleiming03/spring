package spring.boot.data.mybatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class UserPO {

    private Integer id;

    private String name;

    private Timestamp birthday;
}

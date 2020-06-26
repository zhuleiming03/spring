package spring.boot.data.mybatis.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserPO {

    private Integer id;

    private String name;

    private LocalDateTime birthday;

    public UserPO(String name) {
        this.name = name;
    }
}

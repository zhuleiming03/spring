package spring.boot.starter.validation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    @NotNull
    private Integer type;

    @NotNull(message = "当 type = 1 时 query 不为空", groups = ValidGroup.QueryType.class)
    private String query;

    @NotNull(message = "当 type = 2 时 alter 不为空", groups = ValidGroup.AlterType.class)
    private String alter;
}

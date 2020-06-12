package spring.boot.swagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class User {

    @ApiModelProperty(value = "编号", position = 1)
    private Integer id;

    @ApiModelProperty(value = "姓名", position = 2)
    private String name;

    @ApiModelProperty(value = "生日", position = 3)
    private LocalDate birthday;

    @ApiModelProperty(value = "年龄", position = 4)
    private Integer age;
}

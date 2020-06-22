package spring.boot.swagger.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Student {

    @JsonIgnore
    private Integer id;

    private String name;

    @ApiModelProperty(value = "学校", example = "实验中学")
    private String school;
}

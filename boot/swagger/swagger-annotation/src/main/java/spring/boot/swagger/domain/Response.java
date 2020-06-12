package spring.boot.swagger.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {

    private Integer code;

    private String message;

    private T data;
}

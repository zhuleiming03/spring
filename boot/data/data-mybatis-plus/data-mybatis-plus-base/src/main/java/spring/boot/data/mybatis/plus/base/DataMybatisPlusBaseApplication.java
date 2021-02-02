package spring.boot.data.mybatis.plus.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("spring.boot.data.mybatis.plus.base.mapper")
public class DataMybatisPlusBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMybatisPlusBaseApplication.class, args);
    }

}

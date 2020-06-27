package spring.boot.data.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("spring.boot.data.mybatis.mapper")
@SpringBootApplication
public class DataMybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMybatisAnnotationApplication.class, args);
    }

}

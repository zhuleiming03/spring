package spring.boot.data.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("spring.boot.data.mybatis.mapper")
@SpringBootApplication
public class DataMybatisTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataMybatisTransactionalApplication.class, args);
    }

}

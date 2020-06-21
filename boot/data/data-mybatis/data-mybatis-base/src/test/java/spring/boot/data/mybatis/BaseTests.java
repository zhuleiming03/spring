package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.po.UserPO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class BaseTests {

    @Test
    void selectTest() {
        UserPO po = userMapper.select(1);
        System.out.printf("SELECT result: %s \n", po);
    }

    @Test
    void insertTest() {
        UserPO po = new UserPO();
        po.setName("Tom");
        System.out.printf("INSERT result: %s \n", userMapper.insert(po));
    }

    @Test
    void updateTest() {
        UserPO po = new UserPO();
        po.setId(1);
        po.setName("Sean");
        System.out.printf("UPDATE result: %s \n", userMapper.update(po));
    }

    @Test
    void deleteTest() {
        System.out.printf("DELETE result: %s \n", userMapper.delete(1));
    }

    @Autowired
    UserMapper userMapper;

}

package spring.boot.data.mybatis.plus.base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.plus.base.mapper.UserMapper;
import spring.boot.data.mybatis.plus.base.po.User;

@SpringBootTest
class DataMybatisPlusBaseApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}

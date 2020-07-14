package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

@SpringBootTest
class WhereTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void whereTest() {
        System.out.println("---------- type = 1  ---------");
        userMapper.selectWhere(new User(null, null, 1)).forEach(System.out::println);

        System.out.println("---------- name = 鸣人  ---------");
        userMapper.selectWhere(new User(null, "鸣人", null)).forEach(System.out::println);

        System.out.println("---------- type = 1 ANd id=102  ---------");
        userMapper.selectWhere(new User(102, null, 1)).forEach(System.out::println);
    }
}

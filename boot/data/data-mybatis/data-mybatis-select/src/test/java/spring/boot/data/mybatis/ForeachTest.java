package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ForeachTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void insert() {
        List<User> users = Arrays.asList(
                new User(113, "宁次", 1),
                new User(155, "雏田", 1));
        userMapper.insert(users);
    }

    @Test
    void select() {
        List<Integer> ids = Arrays.asList(159, 155);
        userMapper.selectIn(ids).forEach(System.out::println);
    }
}

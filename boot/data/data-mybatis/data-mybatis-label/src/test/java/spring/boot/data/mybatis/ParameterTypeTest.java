package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ParameterTypeTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void testId() {
        System.out.println(userMapper.selectById(159));
    }

    @Test
    void testIdAndName(){
        System.out.println(userMapper.selectByIdAndName(105,"鸣人"));
    }

    @Test
    void testMay() {
        Map<String, Integer> map = new HashMap<>(2);
        map.put("page", 2);
        map.put("size", 2);
        userMapper.selectByMap(map).forEach(System.out::println);
    }

    @Test
    void testObject() {
        User user = new User(105, "鸣人", null);
        System.out.println(userMapper.selectByObject(user));
    }

    @Test
    void testLike() {
        userMapper.selectLike("卡").forEach(System.out::println);
    }
}

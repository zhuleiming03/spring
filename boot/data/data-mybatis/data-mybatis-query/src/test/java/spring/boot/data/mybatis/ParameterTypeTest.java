package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.po.UserPO;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ParameterTypeTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void testMay() {
        Map<String, Integer> map = new HashMap<>(2);
        map.put("page", 2);
        map.put("size", 3);
        userMapper.selectByMap(map).forEach(System.out::println);
    }

    @Test
    void testObject() {
        UserPO userPO = new UserPO();
        userPO.setId(5);
        userPO.setName("Dream");
        System.out.println(userMapper.selectByObject(userPO));
    }

    @Test
    void testId() {
        System.out.println(userMapper.selectById(4));
    }

    @Test
    void testLike() {
        userMapper.selectLike("S").forEach(System.out::println);
    }
}

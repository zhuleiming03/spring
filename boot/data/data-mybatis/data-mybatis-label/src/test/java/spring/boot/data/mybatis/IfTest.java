package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class IfTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void ifTest() {
        Map<String, Integer> map = new HashMap<>(2);
        map.put("type", 1);
        System.out.println("---------- if is null  ---------");
        userMapper.selectIf(map).forEach(System.out::println);
        map.put("id", 105);
        System.out.println("---------- if not null  ---------");
        userMapper.selectIf(map).forEach(System.out::println);
    }
}

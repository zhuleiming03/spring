package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

@SpringBootTest
class ChooseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void chooseTest() {
        System.out.println("---------- type = null  ---------");
        userMapper.selectChoose(new User()).forEach(System.out::println);

        System.out.println("---------- type = 1  ---------");
        userMapper.selectChoose(new User(null, null, 1)).forEach(System.out::println);

        System.out.println("---------- type = 2 ---------");
        userMapper.selectChoose(new User(null, null, 2)).forEach(System.out::println);
    }
}

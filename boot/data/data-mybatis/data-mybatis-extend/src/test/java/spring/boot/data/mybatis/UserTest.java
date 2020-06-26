package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.po.UserPO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void createUserTableTest() {
        userMapper.create();
    }

    @Test
    void batchInsertTest() {

        List<UserPO> userList = Arrays.asList(
                new UserPO("Emma"),
                new UserPO("Noah"),
                new UserPO("Liam"),
                new UserPO("Dre"),
                new UserPO("Dream"),
                new UserPO("Stormi"),
                new UserPO("Saint"),
                new UserPO("Reign"),
                new UserPO("Sophia"));

        userMapper.insert(userList);
    }

    @Test
    void updateReturnIdTest() {

        UserPO po = new UserPO("Liam");
        po.setBirthday(LocalDateTime.of(1990, 1, 15, 14, 50, 29));
        userMapper.update(po);
        System.out.println("id:" + po.getId());
    }
}

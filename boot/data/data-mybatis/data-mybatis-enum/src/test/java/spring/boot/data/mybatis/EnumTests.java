package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.enums.Gender;
import spring.boot.data.mybatis.enums.UserType;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class EnumTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void createTable() {
        userMapper.create();
    }

    @Test
    void insertTest() {
        List<User> users = Arrays.asList(
                new User(null, "伊鲁卡", UserType.TEACHER, Gender.MALE),
                new User(null, "卡卡西", UserType.TEACHER, Gender.MALE),
                new User(null, "佐助", UserType.STUDENT, Gender.MALE),
                new User(null, "鸣人", null, Gender.MALE),
                new User(null, "宁次", UserType.STUDENT, Gender.MALE),
                new User(null, "樱", UserType.STUDENT, Gender.FEMALE));
        userMapper.insert(users);
    }

    @Test
    void selectTest() {
        userMapper.select().forEach(System.out::println);
    }

}

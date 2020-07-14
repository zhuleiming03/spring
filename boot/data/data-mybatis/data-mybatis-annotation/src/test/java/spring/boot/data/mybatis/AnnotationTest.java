package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.User;

@SpringBootTest
class AnnotationTest {

    @Test
    void insertTest() {
        User po = new User();
        po.setName("测试");
        System.out.printf("INSERT result: %s \n", userMapper.insert(po));
    }

    @Test
    void updateTest() {
        User po = new User();
        po.setId(101);
        po.setName("测试");
        System.out.printf("UPDATE result: %s \n", userMapper.update(po));
    }

    @Test
    void selectTest() {
        User po = userMapper.select(101);
        System.out.printf("SELECT result: %s \n", po);
    }

    @Test
    void deleteTest() {
        System.out.printf("DELETE result: %s \n", userMapper.delete(101));
    }

    @Autowired
    UserMapper userMapper;

}

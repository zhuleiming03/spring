package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.dao.UserDao;


@SpringBootTest
class BaseTests {

    @Test
    void initUser() {
        userDao.initUser();
    }

    @Test
    void queryUser() {
        userDao.getUsers().forEach(System.out::println);
    }

    @Autowired
    UserDao userDao;
}

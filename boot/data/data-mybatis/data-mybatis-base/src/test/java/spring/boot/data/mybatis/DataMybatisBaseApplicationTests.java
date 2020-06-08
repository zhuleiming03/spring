package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.po.UserPO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class DataMybatisBaseApplicationTests {

    @Test
    void selectTest() {
        UserPO po = userMapper.select(ID);
        System.out.printf("SELECT result: %s \n", po);
    }

    @Test
    void insertTest() {
        UserPO po = getUser();
        System.out.printf("INSERT result: %s \n", userMapper.insert(po));
    }

    @Test
    void updateTest() {
        UserPO po = getUser();
        po.setBalance(new BigDecimal(109.9));
        po.setVaild(false);
        po.setUpdateTime(LocalDateTime.now());
        System.out.printf("UPDATE result: %s \n", userMapper.update(po));
    }

    @Test
    void deleteTest() {
        System.out.printf("DELETE result: %s \n", userMapper.delete(ID));
    }

    @Autowired
    UserMapper userMapper;

    private static final Long ID = 1000L;

    private UserPO getUser() {
        UserPO po = new UserPO();
        po.setId(ID);
        po.setName("Sean");
        po.setAge(new Short("18"));
        po.setCheapRate(0.9);
        po.setBalance(new BigDecimal(12324.45));
        po.setCreateTime((new Timestamp(System.currentTimeMillis())));
        po.setUpdateTime(LocalDateTime.now());
        po.setVaild(true);
        return po;
    }
}

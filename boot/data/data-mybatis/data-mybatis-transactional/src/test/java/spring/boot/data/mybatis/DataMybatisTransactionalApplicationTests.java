package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.po.UserPO;
import spring.boot.data.mybatis.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

@SpringBootTest
class DataMybatisTransactionalApplicationTests {

    @Test
    void init() {
        UserPO Tom = new UserPO(100L, "Tom", new BigDecimal(1000.00));
        userMapper.insert(Tom);
        UserPO Sean = new UserPO(101L, "Sean", new BigDecimal(100.00));
        userMapper.insert(Sean);
    }

    @Test
    void clear() {
        userMapper.delete(100L);
        userMapper.delete(101L);
    }

    @Test
    void transferTest() {
        try {
            accountUnsafeService.transfer(100L, 101L);
            System.out.println("------- 转账结果  ------\n转账成功");
        } catch (Exception e) {
            System.out.println("------- 转账结果  ------\n转账失败 " + e.getMessage());
        }
    }

    @Autowired
    AccountServiceImpl accountUnsafeService;

    @Autowired
    UserMapper userMapper;
}

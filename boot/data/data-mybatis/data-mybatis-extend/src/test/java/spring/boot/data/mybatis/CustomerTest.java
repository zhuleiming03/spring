package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.enums.LevelEnum;
import spring.boot.data.mybatis.enums.SexEnum;
import spring.boot.data.mybatis.mapper.CustomerMapper;
import spring.boot.data.mybatis.po.CustomerPO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@SpringBootTest
class CustomerTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void createUserTableTest() {
        customerMapper.create();
    }

    @Test
    void insertTest() {
        CustomerPO po = new CustomerPO();
        po.setUserId(5);
        po.setCardNo(10432L);
        po.setLoginName("dear");
        po.setAge(new Short("18"));
        po.setLevel(LevelEnum.Gold);
        po.setSex(SexEnum.FEMALE);
        po.setCheapRate(0.7f);
        po.setBalance(new BigDecimal("3219.32"));
        po.setLastUseTime(LocalDate.now());
        po.setCrateTime(new Timestamp(System.currentTimeMillis()));
        po.setValid(true);
        customerMapper.insert(po);

        po.setUserId(2);
        po.setCardNo(97732L);
        po.setLoginName("guest");
        po.setAge(new Short("29"));
        po.setLevel(LevelEnum.Copper);
        po.setSex(SexEnum.MALE);
        po.setCheapRate(0.9f);
        po.setBalance(new BigDecimal("99.99"));
        po.setLastUseTime(LocalDate.now().plusMonths(1));
        po.setCrateTime(new Timestamp(System.currentTimeMillis()));
        po.setValid(true);
        customerMapper.insert(po);
    }
}

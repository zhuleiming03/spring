package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.AccountMapper;
import spring.boot.data.mybatis.pojo.Account;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class BeforeTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    void initData() {

        accountMapper.create();

        List<Account> accounts = Arrays.asList(
                new Account(10001, "转出账户", new BigDecimal(150.59f)),
                new Account(20001, "转入账户", BigDecimal.ZERO)
        );
        accountMapper.insert(accounts);
    }
}

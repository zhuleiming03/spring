package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.service.AccountService;

import java.math.BigDecimal;

@SpringBootTest
class TransferTest {

    @Autowired
    AccountService accountService;

    @Test
    void transferTest() {
        try {
            accountService.transfer(10001, 20001, new BigDecimal(100f));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        accountService.query();
    }
}

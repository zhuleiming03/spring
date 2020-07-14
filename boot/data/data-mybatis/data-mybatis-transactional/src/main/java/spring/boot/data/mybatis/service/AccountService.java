package spring.boot.data.mybatis.service;

import java.math.BigDecimal;

public interface AccountService {

    void transfer(Integer outerId, Integer innerId, BigDecimal money);

    void query();
}

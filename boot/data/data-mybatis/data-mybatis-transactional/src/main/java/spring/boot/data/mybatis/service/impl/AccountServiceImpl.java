package spring.boot.data.mybatis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.data.mybatis.mapper.AccountMapper;
import spring.boot.data.mybatis.pojo.Account;
import spring.boot.data.mybatis.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void transfer(Integer outerId, Integer innerId, BigDecimal money) {

        System.out.println("------- 转账前  ------");
        query();

        // 转账
        accountMapper.update(outerId, money);
        accountMapper.update(innerId, money.negate());

        System.out.println("------- 转账后  ------");
        accountMapper.select().forEach((u) -> {
            if (u.getBalance().compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException("余额不能小于0");
            }
        });
    }

    @Override
    public void query() {
        accountMapper.select().forEach(System.out::println);
    }

    @Resource
    AccountMapper accountMapper;
}

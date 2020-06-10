package spring.boot.data.mybatis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transfer(Long outerId, Long innerId) {

        System.out.println("------- 转账前  ------");
        userMapper.select().forEach(System.out::println);

        // 转账
        BigDecimal money = new BigDecimal(100);
        userMapper.update(outerId, money);
        money = new BigDecimal(-100);
        userMapper.update(innerId, money);

        System.out.println("------- 转账后  ------");
        userMapper.select().forEach((u) -> {
            System.out.println(u);
            if (u.getBalance().compareTo(new BigDecimal(0)) < 0) {
                throw new RuntimeException("余额不能小于0");
            }
        });
    }

    @Resource
    UserMapper userMapper;
}

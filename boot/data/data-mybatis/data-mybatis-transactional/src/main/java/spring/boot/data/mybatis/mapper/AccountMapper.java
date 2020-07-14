package spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import spring.boot.data.mybatis.pojo.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountMapper {

    void create();

    void insert(List<Account> accounts);

    void update(@Param("id") Integer id, @Param("balance") BigDecimal balance);

    List<Account> select();
}

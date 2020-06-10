package spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import spring.boot.data.mybatis.po.UserPO;

import java.math.BigDecimal;
import java.util.List;

public interface UserMapper {

    List<UserPO> select();

    UserPO selectById(Long id);

    Integer insert(UserPO user);

    Integer update(@Param("id") Long id,@Param("balance") BigDecimal balance);

    Integer delete(Long id);
}

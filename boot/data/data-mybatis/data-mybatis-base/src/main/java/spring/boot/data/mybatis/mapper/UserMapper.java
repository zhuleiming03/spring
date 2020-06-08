package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.UserPO;

public interface UserMapper {

    UserPO select(Long id);

    Integer insert(UserPO user);

    Integer update(UserPO user);

    Integer delete(Long id);
}

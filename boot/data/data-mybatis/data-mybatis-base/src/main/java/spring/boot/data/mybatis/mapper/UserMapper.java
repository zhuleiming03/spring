package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.UserPO;

public interface UserMapper {

    UserPO select(Integer id);

    Integer insert(UserPO user);

    Integer update(UserPO user);

    Integer delete(Integer id);
}

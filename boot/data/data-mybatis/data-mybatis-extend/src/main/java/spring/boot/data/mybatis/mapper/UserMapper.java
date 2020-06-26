package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.UserPO;

import java.util.List;

public interface UserMapper {

    void insert(List<UserPO> users);

    void update(UserPO user);

    void create();
}

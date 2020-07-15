package spring.boot.data.mybatis.mapper.mysql;

import spring.boot.data.mybatis.pojo.User;

import java.util.List;

public interface MyUserMapper {

    void create();

    void insert(User user);

    List<User> select();

}

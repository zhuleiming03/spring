package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    void create();

    void insert(List<User> users);

    List<User> select();
}

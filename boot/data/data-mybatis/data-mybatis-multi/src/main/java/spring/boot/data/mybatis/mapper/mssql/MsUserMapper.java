package spring.boot.data.mybatis.mapper.mssql;

import spring.boot.data.mybatis.pojo.User;

import java.util.List;

public interface MsUserMapper {

    void create();

    void insert(User user);

    List<User> select();

}

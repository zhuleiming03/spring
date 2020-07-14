package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.User;

public interface UserMapper {

    void create();

    User select(Integer id);

    Integer insert(User user);

    Integer update(User user);

    Integer delete(Integer id);
}

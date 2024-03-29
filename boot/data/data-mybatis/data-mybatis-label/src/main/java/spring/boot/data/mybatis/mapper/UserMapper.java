package spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import spring.boot.data.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void create();

    void insert(List<User> users);

    List<User> selectByMap(Map<String, Integer> map);

    User selectByObject(User userPo);

    User selectById(Integer id);

    User selectByIdAndName(@Param("id") Integer id, @Param("name") String name);

    List<User> selectLike(String name);

    List<User> selectIn(List<Integer> ids);

    List<User> selectIf(Map<String, Integer> map);

    List<User> selectWhere(User user);

    List<User> selectChoose(User user);
}

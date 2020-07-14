package spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import spring.boot.data.mybatis.pojo.User;

public interface UserMapper {

    @Select("SELECT id, name AS user_name, birthday FROM t_user WHERE id = #{id}")
    @Results(@Result(property = "name", column = "user_name"))
    User select(@Param("id") Integer id);

    @Insert("INSERT t_user ( name ) VALUES ( #{name} )")
    Integer insert(User user);

    @Update("UPDATE t_user SET id = #{id} WHERE name = #{name}")
    Integer update(User user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    Integer delete(@Param("id") Integer id);
}

package spring.boot.data.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import spring.boot.data.mybatis.po.UserPO;

public interface UserMapper {

    @Select("SELECT id, name, birthday FROM t_user WHERE id = #{id}")
    UserPO select(@Param("id") Integer id);

    @Insert("INSERT t_user ( name ) VALUES ( #{name} )")
    Integer insert(UserPO user);

    @Update("UPDATE t_user SET name = #{name} WHERE id = #{id}")
    Integer update(UserPO user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    Integer delete(@Param("id") Integer id);
}

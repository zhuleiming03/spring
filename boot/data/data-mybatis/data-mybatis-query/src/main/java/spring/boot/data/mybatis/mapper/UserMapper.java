package spring.boot.data.mybatis.mapper;

import org.springframework.stereotype.Service;
import spring.boot.data.mybatis.po.UserPO;

import java.util.List;
import java.util.Map;

@Service
public interface UserMapper {

    List<UserPO> selectByMap(Map<String, Integer> map);

    UserPO selectByObject(UserPO userPo);

    UserPO selectById(Integer id);

    List<UserPO> selectLike(String name);
}

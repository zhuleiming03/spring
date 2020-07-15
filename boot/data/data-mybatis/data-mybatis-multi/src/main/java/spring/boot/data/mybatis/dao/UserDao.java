package spring.boot.data.mybatis.dao;

import org.springframework.stereotype.Component;
import spring.boot.data.mybatis.mapper.mysql.MyUserMapper;
import spring.boot.data.mybatis.pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDao {

    @Resource
    MyUserMapper myUserMapper;

    public List<User> getUsers() {
        return myUserMapper.select();
    }

    public void initUser() {
        myUserMapper.create();
        myUserMapper.insert(new User(null, "鸣人", null));
    }
}

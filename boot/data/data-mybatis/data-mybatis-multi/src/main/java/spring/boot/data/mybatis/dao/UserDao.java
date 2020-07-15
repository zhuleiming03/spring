package spring.boot.data.mybatis.dao;

import org.springframework.stereotype.Component;
import spring.boot.data.mybatis.mapper.mssql.MsUserMapper;
import spring.boot.data.mybatis.mapper.mysql.MyUserMapper;
import spring.boot.data.mybatis.pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDao {

    @Resource
    MyUserMapper myUserMapper;

    @Resource
    MsUserMapper msUserMapper;

    public List<User> getUsers() {
        List<User> users = myUserMapper.select();
        users.addAll(msUserMapper.select());
        return users;
    }

    public void initUser() {
        myUserMapper.create();
        myUserMapper.insert(new User(null, "鸣人", null));
        msUserMapper.create();
        msUserMapper.insert(new User(null, "亚丝娜", null));
    }
}

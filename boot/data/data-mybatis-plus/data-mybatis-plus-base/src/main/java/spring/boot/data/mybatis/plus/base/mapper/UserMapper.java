package spring.boot.data.mybatis.plus.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;
import spring.boot.data.mybatis.plus.base.po.User;

@Service
public interface UserMapper extends BaseMapper<User> {

}

package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.domain.Users;
import spring.boot.data.mybatis.mapper.UsersMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;

@SpringBootTest
class DataMybatisHelperApplicationTests {

    @Test
    void selectTest() {
        Users po = userMapper.selectByPrimaryKey(ID);
        System.out.printf("SELECT result: %s \n", po);
    }

    /**
     * 主键自增
     */
    @Test
    void insertTest() {
        Users po = getUser();
        System.out.printf("INSERT result: %s \n", userMapper.insert(po));
    }

    /**
     * 全量替换
     */
    @Test
    void updateTest() {
        Users po = getUser();
        po.setBalance(new BigDecimal(109.9));
        po.setIsValid(new Byte("0"));
        po.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        System.out.printf("UPDATE result: %s \n", userMapper.updateByPrimaryKeySelective(po));
    }

    @Test
    void deleteTest() {
        System.out.printf("DELETE result: %s \n", userMapper.deleteByPrimaryKey(ID));
    }

    @Autowired
    UsersMapper userMapper;

    private static final Long ID = 10003L;

    private Users getUser() {
        Users po = new Users();
        po.setId(ID);
        po.setUserName("Sean");
        po.setAge(new Short("18"));
        po.setCheapRate(0.9);
        po.setBalance(new BigDecimal(12324.45));
        po.setCreateTime((new Timestamp(System.currentTimeMillis())));
        po.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        po.setIsValid(new Byte("1"));
        return po;
    }

}

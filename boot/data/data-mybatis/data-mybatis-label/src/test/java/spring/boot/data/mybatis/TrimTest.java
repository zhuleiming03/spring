package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.SchoolMapper;
import spring.boot.data.mybatis.pojo.School;

@SpringBootTest
 class TrimTest {

    @Autowired
    SchoolMapper schoolMapper;

    /**
     * prefix	给sql语句拼接的前缀
     * suffix	给sql语句拼接的后缀
     * prefixOverrides	去除sql语句前面的关键字或者字符，该关键字或者字符由prefixOverrides属性指定，
     * suffixOverrides	去除sql语句后面的关键字或者字符，该关键字或者字符由suffixOverrides属性指定
     * 假设该属性指定为","，当sql语句的结尾为","，trim标签将会去除该","
     */
    @Test
    void trimTest() {
        System.out.println("---------- 根据 id 排序 ---------");
        schoolMapper.trim(new School(1, null));
        System.out.println("---------- 根据 name 排序 ---------");
        schoolMapper.trim(new School(null, "name"));
        System.out.println("---------- 根据 id,name 排序 ---------");
        schoolMapper.trim(new School(1, "name"));
    }

    @Test
    void init() {
        School school = new School(null, "云隐村小学");
        schoolMapper.insert(school);
        school.setName("砂隐村中学");
        schoolMapper.insert(school);
    }
}

package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.CustomerMapper;
import spring.boot.data.mybatis.mapper.TeacherMapper;

@SpringBootTest
class ResultMapTest {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void definedResultMapTest() {
        System.out.println(customerMapper.select(5));
    }

    @Test
    void associationJoinTest() {
        System.out.println(teacherMapper.getTeacherJoinSchool(110));
    }

    @Test
    void associationInTest() {
        System.out.println(teacherMapper.getTeacherInSchool(110));
    }

    @Test
    void collectionJoinTest() {
        System.out.println(teacherMapper.getTeacherJoinClass(110));
    }

    @Test
    void collectionInTest() {
        System.out.println(teacherMapper.getTeacherInClass(110));
    }
}

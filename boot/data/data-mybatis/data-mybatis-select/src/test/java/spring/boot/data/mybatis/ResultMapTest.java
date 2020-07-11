package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.TeacherMapper;

@SpringBootTest
class ResultMapTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void resultMapTest() {
        teacherMapper.getStudent(202).forEach(System.out::println);
    }

    @Test
    void associationTest() {
        System.out.println(">>>  " + teacherMapper.getTeacherJoinSchool(202));
        System.out.println(">>>  " + teacherMapper.getTeacherInSchool(202));
    }

    @Test
    void collectionTest() {
        System.out.println(">>>  " + teacherMapper.getTeacherJoinStudent(202));
        System.out.println(">>>  " + teacherMapper.getTeacherInStudent(202));
    }
}

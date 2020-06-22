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
    void associationJoinTest() {
        System.out.println(teacherMapper.getTeacherByJoin(2));
    }

    @Test
    void associationInTest() {
        System.out.println(teacherMapper.getTeacherByIn(2));
    }

    @Test
    void collectionJoinTest() {
        teacherMapper.getStudentByJoin(2).forEach(System.out::println);
    }
}

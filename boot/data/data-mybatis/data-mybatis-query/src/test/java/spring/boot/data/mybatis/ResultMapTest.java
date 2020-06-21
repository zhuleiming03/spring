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
    void aa() {
        System.out.println(teacherMapper.getTeacher(2));
    }

    @Test
    void bb() {
        System.out.println(teacherMapper.getTeacher2(2));
    }

    @Test
    void cc() {
        teacherMapper.getStudent(2).forEach(System.out::println);
    }
}

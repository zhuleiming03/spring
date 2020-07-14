package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.StudentMapper;
import spring.boot.data.mybatis.pojo.Student;

@SpringBootTest
class SetTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void setTest() {
        Student student = new Student(105, null, 211);
        studentMapper.update(student);
    }
}

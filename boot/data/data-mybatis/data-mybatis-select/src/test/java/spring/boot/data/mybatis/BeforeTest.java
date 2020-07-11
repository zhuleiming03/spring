package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.SchoolMapper;
import spring.boot.data.mybatis.mapper.StudentMapper;
import spring.boot.data.mybatis.mapper.TeacherMapper;
import spring.boot.data.mybatis.mapper.UserMapper;
import spring.boot.data.mybatis.pojo.School;
import spring.boot.data.mybatis.pojo.Student;
import spring.boot.data.mybatis.pojo.Teacher;
import spring.boot.data.mybatis.pojo.User;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class BeforeTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SchoolMapper schoolMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void initTable() {
        userMapper.create();
        studentMapper.create();
        schoolMapper.create();
        teacherMapper.create();
    }

    @Test
    void intiDate() {

        List<User> users = Arrays.asList(
                new User(202, "卡卡西", 2),
                new User(102, "佐助", 1),
                new User(105, "鸣人", 1),
                new User(159, "樱", 1));
        userMapper.insert(users);

        List<Student> students = Arrays.asList(
                new Student(102, "宇智波", 202),
                new Student(105, "漩涡", 202),
                new Student(159, "春野", 202)
        );
        studentMapper.insert(students);

        School school = new School(null, "木叶忍者学校");
        schoolMapper.insert(school);

        teacherMapper.insert(new Teacher(202, "上忍", school.getId(), null, null));
    }
}

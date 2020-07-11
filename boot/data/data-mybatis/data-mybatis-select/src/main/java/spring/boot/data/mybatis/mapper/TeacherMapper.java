package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.Student;
import spring.boot.data.mybatis.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    void create();

    void insert(Teacher teacher);

    Teacher getTeacherJoinSchool(Integer id);

    Teacher getTeacherInSchool(Integer id);

    Teacher getTeacherJoinStudent(Integer id);

    Teacher getTeacherInStudent(Integer id);

    List<Student> getStudent(Integer id);
}

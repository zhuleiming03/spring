package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {

    void create();

    void insert(List<Student> students);

    void update(Student student);
}

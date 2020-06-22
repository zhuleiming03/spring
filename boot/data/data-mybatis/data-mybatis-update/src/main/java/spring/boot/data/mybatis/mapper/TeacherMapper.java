package spring.boot.data.mybatis.mapper;

import org.springframework.stereotype.Service;
import spring.boot.data.mybatis.po.TeacherPO;


@Service
public interface TeacherMapper {

    Integer updateTeacher(TeacherPO teacherPO);

}

package spring.boot.data.mybatis.mapper;

import org.springframework.stereotype.Service;
import spring.boot.data.mybatis.po.TeacherPO;

import java.util.List;

@Service
public interface TeacherMapper {

    TeacherPO getTeacher(Integer id);

    TeacherPO getTeacher2(Integer id);

    List<TeacherPO> getStudent(Integer id);
}

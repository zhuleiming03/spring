package spring.boot.data.mybatis.mapper;

import org.springframework.stereotype.Service;
import spring.boot.data.mybatis.po.TeacherPO;

import java.util.List;

@Service
public interface TeacherMapper {

    TeacherPO getTeacherByIn(Integer id);

    TeacherPO getTeacherByJoin(Integer id);

    List<TeacherPO> getStudentByJoin(Integer id);
}

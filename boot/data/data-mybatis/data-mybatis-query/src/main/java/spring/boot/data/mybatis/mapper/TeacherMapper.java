package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.TeacherPO;

public interface TeacherMapper {

    TeacherPO getTeacherJoinSchool(Integer id);

    TeacherPO getTeacherInSchool(Integer id);

    TeacherPO getTeacherJoinClass(Integer id);

    TeacherPO getTeacherInClass(Integer id);
}

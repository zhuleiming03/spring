package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.TeacherPO;

public interface TeacherMapper {

    void create();

    void insert(TeacherPO teacherPo);
}

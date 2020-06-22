package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.TeacherMapper;
import spring.boot.data.mybatis.po.TeacherPO;

@SpringBootTest
class UpdateTest {

    @Test
    void contextLoads() {

        TeacherPO teacherPO = new TeacherPO();
        teacherPO.setSchool(1);
        teacherPO.setCourse("英语");
        System.out.println(teacherMapper.updateTeacher(teacherPO));
        System.out.println(teacherPO);
    }

    @Autowired
    TeacherMapper teacherMapper;
}

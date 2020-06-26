package spring.boot.data.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.data.mybatis.mapper.TeacherMapper;
import spring.boot.data.mybatis.po.ClassPO;
import spring.boot.data.mybatis.po.SchoolPO;
import spring.boot.data.mybatis.po.TeacherPO;

import java.util.Arrays;

@SpringBootTest
 class TeacherTest {

    @Autowired
    TeacherMapper teacherMapper;

    @Test
    void create() {
        teacherMapper.create();
    }

    @Test
    void insert() {
        TeacherPO teacher = new TeacherPO(110, "Sean");
        teacher.setSchoolPo(new SchoolPO(11, "实验中学"));
        teacher.setClasses(Arrays.asList(new ClassPO(1, "No.301"),
                new ClassPO(2, "No.306"),
                new ClassPO(3, "No.308")));
        teacherMapper.insert(teacher);
    }
}

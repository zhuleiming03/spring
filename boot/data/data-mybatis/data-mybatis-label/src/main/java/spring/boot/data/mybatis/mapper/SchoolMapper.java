package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.School;

import java.util.List;

public interface SchoolMapper {

    void create();

    void insert(School school);

    List<School> trim(School school);
}

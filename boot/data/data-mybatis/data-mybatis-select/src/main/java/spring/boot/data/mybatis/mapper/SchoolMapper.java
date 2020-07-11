package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.pojo.School;

public interface SchoolMapper {

    void create();

    void insert(School school);
}

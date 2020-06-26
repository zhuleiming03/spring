package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.po.CustomerPO;

public interface CustomerMapper {

    void create();

    int insert(CustomerPO po);
}

package spring.boot.data.mybatis.mapper;

import spring.boot.data.mybatis.vo.CustomerVO;

public interface CustomerMapper {

    CustomerVO select(Integer id);
}

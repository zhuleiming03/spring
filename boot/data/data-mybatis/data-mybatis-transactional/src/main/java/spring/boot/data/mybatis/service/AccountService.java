package spring.boot.data.mybatis.service;

public interface AccountService {

    void transfer(Long outerId, Long innerId);
}

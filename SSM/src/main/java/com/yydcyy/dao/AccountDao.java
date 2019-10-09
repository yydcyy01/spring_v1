package com.yydcyy.dao;

import com.yydcyy.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户接口, 不需要写实现类, 框架实现
 * @author YYDCYY
 * @create 2019-10-09
 */
@Repository
public interface AccountDao {
    // 查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    // 保存帐户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);
}

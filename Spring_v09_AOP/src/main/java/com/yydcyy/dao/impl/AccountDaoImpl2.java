package com.yydcyy.dao.impl;

import com.yydcyy.dao.IAccountDao;
import com.yydcyy.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现类
 * @author YYDCYY
 * @create 2019-09-27
 * 若这里语句错了, 大概率是拼写错了, 仔细点, 看不出来直接删了再写一遍
 */
@Repository
public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        //查询sql 语句中的 ?  占位符别少了
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                accountId);

        return accounts.isEmpty()?null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                accountName);

        if (accounts.isEmpty())
            return null;

        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }

        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",
                account.getName(),account.getMoney(),account.getId());

    }

}

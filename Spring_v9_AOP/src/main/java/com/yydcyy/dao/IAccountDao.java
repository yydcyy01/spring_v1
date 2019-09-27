package com.yydcyy.dao;

import com.yydcyy.domain.Account;

/**
 * @author YYDCYY
 * @create 2019-09-27
 */
public interface IAccountDao {

    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}

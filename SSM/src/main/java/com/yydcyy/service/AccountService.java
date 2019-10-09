package com.yydcyy.service;

import com.yydcyy.domain.Account;

import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-10-09
 */
public interface AccountService {

    // 查询所有账户
    public List<Account> findAll();

    // 保存帐户信息
    public void saveAccount(Account account);


}
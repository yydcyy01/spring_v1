package com.yydcyy.service.impl;

import com.yydcyy.dao.AccountDao;
import com.yydcyy.domain.Account;
import com.yydcyy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-10-09
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

     @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return accountDao.findAll();
        //return null;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        accountDao.saveAccount(account);
    }
}

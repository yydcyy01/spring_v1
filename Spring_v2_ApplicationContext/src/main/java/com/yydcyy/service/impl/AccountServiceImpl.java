package com.yydcyy.service.impl;

/**
 * @author YYDCYY
 * @create 2019-09-23
 */

import com.yydcyy.dao.IAccountDao;
import com.yydcyy.dao.impl.AccountDaoImpl;
import com.yydcyy.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
//    private int i = 1;

    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}

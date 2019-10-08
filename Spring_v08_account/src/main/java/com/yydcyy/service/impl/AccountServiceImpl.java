package com.yydcyy.service.impl;

import com.yydcyy.dao.IAccountDao;
import com.yydcyy.domain.Account;
import com.yydcyy.service.IAccountService;
import com.yydcyy.utils.TransactionManager;


import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制应该都是在业务层(Service)
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManager txManager;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    @Override
    public List<Account> findAllAccount() {
        try {
            //1 开启事务
            txManager.beginTransaction();
            //2 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3 提交事务
            txManager.commit();
            //4 返回结果
            return accounts;
        } catch (Exception e) {
            //e.printStackTrace();
            //5 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6 释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1 开启事务
            txManager.beginTransaction();

            //2 执行操作
            Account account = accountDao.findAccountById(accountId);
            //3 提交事务
            txManager.commit();
            //4 返回结果
            return account;
        } catch (Exception e) {
           //e.printStackTrace();
            //5 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {

            //6 释放连接
            txManager.release();
        }
        //return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        try {
        //1 开启事务
        txManager.beginTransaction();

        //2 执行操作
        accountDao.saveAccount(account);
        //3 提交事务
        txManager.commit();
        //4 返回结果
        //void
    } catch (Exception e) {
        //e.printStackTrace();
        //5 回滚操作
        txManager.rollback();
        throw new RuntimeException(e);
    }finally {

        //6 释放连接
        txManager.release();
    }
        //accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1 开启事务
            txManager.beginTransaction();

            //2 执行操作
            accountDao.updateAccount(account);
            //3 提交事务
            txManager.commit();
            //4 返回结果
            //null
        } catch (Exception e) {
           // e.printStackTrace();
            //5 回滚操作
            txManager.rollback();
           // throw new RuntimeException(e);
        }finally {

            //6 释放连接
            txManager.release();
        }
        //accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {

        try {
            //1 开启事务
            txManager.beginTransaction();

            //2 执行操作
            accountDao.deleteAccount(acccountId);
            //3 提交事务
            txManager.commit();
            //4 返回结果
            //void
        } catch (Exception e) {
           // e.printStackTrace();
            //5 回滚操作
            txManager.rollback();
           // throw new RuntimeException(e);
        }finally {

            //6 释放连接
            txManager.release();
        }
        //accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        /*//1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5更新转出账户
        accountDao.updateAccount(source);
//            int i=1/0;

        //6更新转入账户
        accountDao.updateAccount(target);*/

        try {
            //1 开启事务
            txManager.beginTransaction();

            //2 执行操作
                //2.1根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.2根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //2.3转出账户减钱
                source.setMoney(source.getMoney() - money);
                //2.4转入账户加钱
                target.setMoney(target.getMoney() + money);
                //2.5更新转出账户
                accountDao.updateAccount(source);
                //int i=1/0;

                //2.6更新转入账户
                accountDao.updateAccount(target);
            //3 提交事务
            txManager.commit();
            //4 返回结果
            //null
        } catch (Exception e) {
            //5 回滚操作
            txManager.rollback();
        }finally {
            //6 释放连接
            txManager.release();
        }
    }
}

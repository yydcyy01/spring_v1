package com.yydcyy.service.impl;

/**
 * @author YYDCYY
 * @create 2019-09-23
 *  Demo Bean, 取出 dao 层, 直接打印输出测试.   []
 */


import com.yydcyy.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        System.out.println("service 中的 saveAccount 方法执行了...");
    }
    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}

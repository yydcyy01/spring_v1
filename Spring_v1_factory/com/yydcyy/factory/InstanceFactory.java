package com.yydcyy.factory;

import com.yydcyy.service.IAccountService;
import com.yydcyy.service.impl.AccountServiceImpl;

/**
 * @author YYDCYY
 * @create 2019-09-24
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}

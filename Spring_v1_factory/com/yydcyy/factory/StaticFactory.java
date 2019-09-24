package com.yydcyy.factory;

import com.yydcyy.service.IAccountService;
import com.yydcyy.service.impl.AccountServiceImpl;

/**
 * @author YYDCYY
 * @create 2019-09-24
 */
public class StaticFactory {
    public static IAccountService getAccountService(){

        return new AccountServiceImpl();
    }
}

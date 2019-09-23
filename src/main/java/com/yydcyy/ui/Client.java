package com.yydcyy.ui;

import com.yydcyy.factory.BeanFactory;
import com.yydcyy.service.IAccountService;

/**
    * 模拟一个表现层，用于调用业务层
 * @author YYDCYY
 * @create 2019-09-23
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}

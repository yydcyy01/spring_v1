package com.yydcyy.service.impl;

/**
 * @author YYDCYY
 * @create 2019-09-23
 *  Demo Bean, 取出 dao 层, 直接打印输出测试.   []
 */


import com.yydcyy.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;


    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("service 中的 saveAccount 方法执行了..." + name + ", " + age + ", " + birthday);
    }


}

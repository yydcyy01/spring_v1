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
public class AccountServiceImpl2 implements IAccountService {
    //如果是经常变化的数据，并不适用于注入的方式

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("service 中的 saveAccount 方法执行了..." + name + ", " + age + ", " + birthday);
    }


}

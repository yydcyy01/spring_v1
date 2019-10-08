package com.yydcyy.service.impl;

/**
 * @author YYDCYY
 * @create 2019-09-23
 *  Demo Bean, 取出 dao 层, 直接打印输出测试.   []
 */


import com.yydcyy.service.IAccountService;

import java.util.*;
import java.util.Set;

/**
 * 账户的业务层实现类
 * 复杂 / 集合类型注入
 */
public class AccountServiceImpl3 implements IAccountService {


private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }


    public void  saveAccount(){
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }


}

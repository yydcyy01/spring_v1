package com.yydcyy.test;

import com.yydcyy.dao.IAccountDao;
import com.yydcyy.domain.Account;
import com.yydcyy.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-09-25
 */
public class AccountServiceTest {
    ClassPathXmlApplicationContext ac;
    private IAccountService as;

    @Before
    public void init(){
        //1 获取
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        this.ac = new ClassPathXmlApplicationContext("bean.xml");

        //2 得到业务层对象
        this.as = ac.getBean("accountService",IAccountService.class);
    }
    @After
    public void after(){
        ac.close();
    }

    @Test
    public void testFindAll() {

        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test2");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(6);
    }
}

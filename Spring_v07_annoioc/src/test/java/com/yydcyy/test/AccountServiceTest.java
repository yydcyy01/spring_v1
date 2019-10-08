package com.yydcyy.test;

import com.yydcyy.config.SpringConfiguration;
import com.yydcyy.dao.IAccountDao;
import com.yydcyy.domain.Account;
import com.yydcyy.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author YYDCYY
 * @create 2019-09-25
 */

/**
 * 使用Junit单元测试：测试我们的配置
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class) //com.yydcyy.config.SpringConfiguration 右键复制到 Reference 地址
public class AccountServiceTest {
    //AnnotationConfigApplicationContext ac;
    @Autowired
    private IAccountService as;
/*
    @Before
    public void init(){
        //1 获取 改为注解方式
         //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //this.ac = new ClassPathXmlApplicationContext("bean.xml");
        this.ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2 得到业务层对象
        this.as = ac.getBean("accountService",IAccountService.class);
    }
    @After
    public void after(){
        ac.close();
    }*/

   /* @Test
    public  void  testQueryRunner(){
        //1.获取
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);
    }*/


    /**
     * JdbcConfig 配置
     * "    * 用于创建一个QueryRunner对象
     *      * @param dataSource
     *      * @return
     *
     *@Bean(name = "runner")
     *public QueryRunner createQueryRunner (@Qualifier("ds2") DataSource dataSource){"
     * 默认是 单例模式.  导致此类输出 true;
     * 但是有悖于 xml 原文件 : Prototype 多例模式
     * 加上:  @Scope(Prototype) ,
     * 变为多例模式, 故sout 输出 false
     */
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

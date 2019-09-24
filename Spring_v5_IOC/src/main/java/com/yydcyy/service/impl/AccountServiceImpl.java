package com.yydcyy.service.impl;

/**
 * @author YYDCYY
 * @create 2019-09-23
 *  Demo Bean, 取出 dao 层, 直接打印输出测试.   []
 */


import com.yydcyy.dao.IAccountDao;
import com.yydcyy.service.IAccountService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 账户的业务层实现类
 */
//@Scope("prototype")
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    /**
     * 账户的业务层实现类
     *
     * 曾经XML的配置：
     *  <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
     *        scope=""  init-method="" destroy-method="">
     *      <property name=""  value="" | ref=""></property>
     *  </bean>
     *
     * 用于创建对象的
     *      他们的作用就和在XML配置文件中编写一个<bean>标签实现的功能是一样的
     *      Component:
     *          作用：用于把当前类对象存入spring容器中 [不知道那一层, 用这个, 通用]
     *          属性：
     *              value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
     *      Controller：一般用在表现层
     *      Service：一般用在业务层
//     *      Repository：一般用在持久层
     *      以上三个注解他们的作用和属性与Component是一模一样。
     *      他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
     *
     *
     * 用于注入数据的
     *      他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
     *      Autowired:
     *      出现位置：
     *      *   可以是变量上，也可以是方法上
     *          作用：自动按照类型注入。只要容器中有[唯一] (不唯一就报错)的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
     *                如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
     *                如果Ioc容器中有多个类型匹配时：组合 Qualifier 使用
     *          细节：
     *              在使用注解注入时，set方法就不是必须的了。
     *
     *      Qualifier:
     *          作用：在按照类中注入的基础之上再按照名称注入。它在给类成员注入时 不能单独 使用。但是在给 方法 参数注入时 可以（稍后我们讲）
     *          属性：
     *              value：用于指定注入bean的id。
     *
     *
     *      Resource (优点 : 可单独使用, 不需要记 啥啥组合使用
     *          作用：直接按照 bean 的 id 注入。它可以独立使用
     *          属性：
     *              (其他是 value, 区别记忆)name：用于指定bean的id。
     *
     *      以上三个注入都只能注入其他bean类型的数据，不可用于基本数据类型和 String (另有方法Value)
     *      另外，集合类型的注入只能通过XML来实现。
     *
     *      Value
     *          作用：用于注入基本类型和String类型的数据
     *          属性：
     *              value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式）
     *                      SpEL的写法：${表达式}  虽然都叫 EL 但是取值可不是四大域哦. 写在 JSP 中, 就是 JSp 的 el 表达式, 去四大域找, MyBatis 的 El 表达式, 就去 MyBatis 域中找.
     *                      SpEl 就去 容器中找.  所以别混了, 找对应的.
     *
     * 用于改变作用范围的
     *      他们的作用就和在bean标签中使用scope属性实现的功能是一样的
     *      Scope
     *          作用：用于指定bean的作用范围
     *          属性：
     *              value：指定范围的取值。常用取值：singleton prototype
     *
     * 和生命周期相关 了解
     *      他们的作用就和在bean标签中使用init-method和destroy-methode的作用是一样的
     *      PreDestroy
     *          作用：用于指定销毁方法
     *      PostConstruct
     *          作用：用于指定初始化方法
     */

    /*@Autowired
    @Qualifier("accountDao1")*/
    @Resource(name = "accountDao2")
    private IAccountDao accountDao = null;


    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁方法执行了");
    }


    public void  saveAccount(){
        accountDao.saveAccount();
    }


}

package com.yydcyy.ui;



import com.yydcyy.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
    * 模拟一个表现层，用于调用业务层
 *删除 Dao层, 直接 service 层输出 [重点在 xml 配置读取 Service 层方案.]
 * @author YYDCYY
 * @create 2019-09-23
 */
public class Client {
    /**
     *
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * UML 图中可以看到:
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限 Windows / mac 可能就没有访问权限
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，下次具体详解
     *
     * 核心容器的两个接口引发出的问题： [可 sout 输出,debug 单步调试看哪一步打印]
     *  ApplicationContext:     单例对象适用              采用此接口
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。
     *
     *  BeanFactory:            多例对象使用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
        public static void main(String[] args) {
            // 1.获取核心容器对象  及自己模拟中的 Map, 先获取, 然后打算取数据
            //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");


            IAccountService as  = (IAccountService)ac.getBean("accountService");
            as.saveAccount();

            //手动关闭容器 则应用多态, ac 为ClassPathXmlApplicationContext 而不是ApplicationContext 容器生成
            ac.close();
        }
}

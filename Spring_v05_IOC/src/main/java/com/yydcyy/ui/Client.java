package com.yydcyy.ui;



import com.yydcyy.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
    * 模拟一个表现层，用于调用业务层
 *删除 Dao层, 直接 service 层输出 [重点在 xml 配置读取 Service 层方案.]
 * @author YYDCYY
 * @create 2019-09-23
 */
public class Client {
    /**
     * @param args
     */
        public static void main(String[] args) {
            // 1.获取核心容器对象  及自己模拟中的 Map, 先获取, 然后打算取数据
            //ApplicatlionContext ac = new CassPathXmlApplicationContext("bean.xml");
            ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

            IAccountService as  = (IAccountService)ac.getBean("accountService");
            as.saveAccount();

            //手动关闭容器 则应用多态, ac 为ClassPathXmlApplicationContext 而不是ApplicationContext 容器生成
            ac.close();
        }
}

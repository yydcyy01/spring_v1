package com.yydcyy.config;

/**
 * @author YYDCYY
 * @create 2019-09-25
 * 该类是一个配置类，它的作用和bean.xml是一样的
 */


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//@Configuration
@ComponentScan("com.yydcyy")
//@ComponentScan(/*value =*/ basePackages = {"com.yydcyy"}) //这是标准写法, 因为只有一个属性, 省去大括号, value 变成上面模式
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
//@PropertySource("jdbcConfig.properties") // 这个写法怕项目传到服务器, resource 包被放到了 类路径下, 前面加个动态获取类路径 classpath:+文件
public class SpringConfiguration {

/**
 * spring中的新注解
 * Configuration
 *     作用：指定当前类是一个配置类
 *     细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包。
 *                 我们使用此注解就等同于在xml中配置了:
 *                      <context:component-scan base-package="com.itheima"></context:component-scan>
 *  Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性:
 *          name:用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
 *          查找的方式和Autowired注解的作用是一样的
 *  Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码。
 *                  当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
 *  PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径。
 *                  关键字：classpath，表示类路径下
 */
}

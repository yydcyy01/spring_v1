package com.yydcyy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 *模拟一个消费者
 * @author YYDCYY
 * @create 2019-09-26
 *
 */
public class Client {

    /**
     * 动态代理：
     *  特点：字节码随用随创建，随用随加载
     *  作用：不修改源码的基础上对方法增强
     *  分类：
     *      基于接口的动态代理
     *      基于子类的动态代理
     *  基于子类的动态代理：
     *      涉及的类：Enhancer
     *      提供者：第三方cglib库 :Cglib是一个强大的、高性能的代码生成包，它广泛被许多AOP框架使用，为他们提供方法的拦截。
     *  如何创建代理对象：
     *      使用Enhancer类中的create方法
     *  创建代理对象的要求：
     *      被代理类不能是最终类
     *  create方法的参数：
     *      Class：字节码
     *          它是用于指定被代理对象的字节码。
     *
     *      Callback：用于提供增强的代码
     *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
     *          此接口的实现类都是谁用谁写。
     *          我们一般写的都是该接口的子接口实现类：MethodInterceptor
     */

    public static void main(String[] args) {
       Producet producer = new Producet();

        Producet cglibProducet = (Producet) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * intercept方法的参数名并不是原生的参数名，我做了自己的调整，几个参数的含义为：
             * Object表示要进行增强的对象
             * Method表示拦截的方法
             * Object[]数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
             * MethodProxy表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强代码
                Object returnValue = null;
                //1 获取方法执行的参数
                float money = (float) args[0];
                //2 判断当前的方法是不是销售
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer, money * 0.7f);
                }
                return returnValue;
            }
        });
        cglibProducet.saleProduct(10000f);
    }
}

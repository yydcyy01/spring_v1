package com.yydcyy.cglib;

/**
 * 一个生产者
 *
 * @author YYDCYY
 * @create 2019-09-26
 */
public class Producet {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }

    /*
    售后
     */
    public void afterServict(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }


}

package com.yydcyy.domain;

import java.io.Serializable;

/**
 * @author YYDCYY
 * @create 2019-09-27
 */
public class Account implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    private Integer id;
    private String name;
    private Float money;
}

package com.example.demo.entity;

/**
 * 商品类
 */
public class Commodity {
    private int id;
    private String name;//商品名称
    private int commoditynum;//商品数量

    public Commodity() {
    }

    public Commodity(int id, String name, int commoditynum) {
        this.id = id;
        this.name = name;
        this.commoditynum = commoditynum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommoditynum() {
        return commoditynum;
    }

    public void setCommoditynum(int commoditynum) {
        this.commoditynum = commoditynum;
    }
}

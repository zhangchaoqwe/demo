package com.example.demo.entity;

/**
 * 消费记录
 */
public class Consumption {
    private int id;
    private int userid;//用户id
    private int commodityid;//商品id
    private int commoditynum;//商品数量

    public Consumption() {
    }

    public Consumption(int id, int userid, int commodityid, int commoditynum) {
        this.id = id;
        this.userid = userid;
        this.commodityid = commodityid;
        this.commoditynum = commoditynum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCommodityid() {
        return commodityid;
    }

    public void setCommodityname(String Commodityid) {
        this.commodityid = commodityid;
    }

    public int getCommoditynum() {
        return commoditynum;
    }

    public void setCommoditynum(int commoditynum) {
        this.commoditynum = commoditynum;
    }

}

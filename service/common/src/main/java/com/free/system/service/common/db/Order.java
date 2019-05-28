package com.free.system.service.common.db;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/28
 * @version 1.0.0
 **/
public class Order {
    private int colIdex;
    private String colName = "id";
    private String direction = "desc";
    private Boolean desc;
    private String sort;
    private String order;
    private static final String DEFALUT_COLNAME = "id";

    public Order() {
    }

    public static Order build() {
        Order order = new Order();
        order.setColName("id");
        order.setDesc(true);
        return order;
    }

    public static Order build(String colName) {
        Order order = new Order();
        order.setColName(colName);
        order.setDesc(true);
        return order;
    }

    public Boolean getDesc() {
        return this.desc != null ? this.desc : "desc".equals(this.direction);
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public String getColName() {
        return this.colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public int getColIdex() {
        return this.colIdex;
    }

    public void setColIdex(int colIdex) {
        this.colIdex = colIdex;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        this.colName = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
        this.direction = order;
    }
}


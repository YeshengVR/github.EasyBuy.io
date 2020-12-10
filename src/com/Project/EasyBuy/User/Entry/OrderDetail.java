package com.Project.EasyBuy.User.Entry;

/**
 * 订单明细
 */
public class OrderDetail {
    private Number ID;
    private Number ORDERID;
    private Number PRODUCTID;
    private Number QUANTITY;//数量
    private Number COST;

    public Number getID() {
        return ID;
    }

    public void setID(Number ID) {
        this.ID = ID;
    }

    public Number getORDERID() {
        return ORDERID;
    }

    public void setORDERID(Number ORDERID) {
        this.ORDERID = ORDERID;
    }

    public Number getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Number PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public Number getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Number QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public Number getCOST() {
        return COST;
    }

    public void setCOST(Number COST) {
        this.COST = COST;
    }

    public OrderDetail() {
    }

    public OrderDetail(Number ID, Number ORDERID, Number PRODUCTID, Number QUANTITY, Number COST) {
        this.ID = ID;
        this.ORDERID = ORDERID;
        this.PRODUCTID = PRODUCTID;
        this.QUANTITY = QUANTITY;
        this.COST = COST;
    }
}

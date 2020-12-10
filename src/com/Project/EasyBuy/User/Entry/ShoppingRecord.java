package com.Project.EasyBuy.User.Entry;

import java.util.Date;

public class ShoppingRecord {
    private Number ID;
    private Number USERID;
    private Number PRODUCTID;
    private Number PRICE;
    private Number AMOUNT;
    private Date CREATETIME;
    private String FILENAME;
    private Number CCODEID;

    @Override
    public String toString() {
        return "ShoppingRecord{" +
                "ID=" + ID +
                ", USERID=" + USERID +
                ", PRODUCTID=" + PRODUCTID +
                ", PRICE=" + PRICE +
                ", AMOUNT=" + AMOUNT +
                ", CREATETIME=" + CREATETIME +
                ", FILENAME='" + FILENAME + '\'' +
                ", CCODEID=" + CCODEID +
                '}';
    }

    public ShoppingRecord(Number ID, Number USERID, Number PRODUCTID, Number PRICE, Number AMOUNT, Date CREATETIME, String FILENAME, Number CCODEID) {
        this.ID = ID;
        this.USERID = USERID;
        this.PRODUCTID = PRODUCTID;
        this.PRICE = PRICE;
        this.AMOUNT = AMOUNT;
        this.CREATETIME = CREATETIME;
        this.FILENAME = FILENAME;
        this.CCODEID = CCODEID;
    }

    public Number getCCODEID() {
        return CCODEID;
    }

    public void setCCODEID(Number CCODEID) {
        this.CCODEID = CCODEID;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public Number getID() {
        return ID;
    }

    public void setID(Number ID) {
        this.ID = ID;
    }

    public Number getUSERID() {
        return USERID;
    }

    public void setUSERID(Number USERID) {
        this.USERID = USERID;
    }

    public Number getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Number PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public Number getPRICE() {
        return PRICE;
    }

    public void setPRICE(Number PRICE) {
        this.PRICE = PRICE;
    }

    public Number getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(Number AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public ShoppingRecord() {
    }

}

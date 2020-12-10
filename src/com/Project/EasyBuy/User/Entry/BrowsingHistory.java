package com.Project.EasyBuy.User.Entry;

import java.util.Date;

public class BrowsingHistory {
    private Number ID;
    private String FILENAME;
    private Number PRODUCTID;
    private String NAME;
    private String DESPCRIPTION;
    private Number PRICE;
    private Date CREATETIME;
    private Number USERID;

    public BrowsingHistory() {
    }

    @Override
    public String toString() {
        return "BrowsingHistory{" +
                "ID=" + ID +
                ", FILENAME='" + FILENAME + '\'' +
                ", PRODUCTID=" + PRODUCTID +
                ", NAME='" + NAME + '\'' +
                ", DESPCRIPTION='" + DESPCRIPTION + '\'' +
                ", PRICE=" + PRICE +
                ", CREATETIME=" + CREATETIME +
                ", USERID=" + USERID +
                '}';
    }

    public BrowsingHistory(Number ID, String FILENAME, Number PRODUCTID, String NAME, String DESPCRIPTION, Number PRICE, Date CREATETIME, Number USERID) {
        this.ID = ID;
        this.FILENAME = FILENAME;
        this.PRODUCTID = PRODUCTID;
        this.NAME = NAME;
        this.DESPCRIPTION = DESPCRIPTION;
        this.PRICE = PRICE;
        this.CREATETIME = CREATETIME;
        this.USERID = USERID;
    }

    public Number getUSERID() {
        return USERID;
    }

    public void setUSERID(Number USERID) {
        this.USERID = USERID;
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

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public Number getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Number PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESPCRIPTION() {
        return DESPCRIPTION;
    }

    public void setDESPCRIPTION(String DESPCRIPTION) {
        this.DESPCRIPTION = DESPCRIPTION;
    }

    public Number getPRICE() {
        return PRICE;
    }

    public void setPRICE(Number PRICE) {
        this.PRICE = PRICE;
    }
}

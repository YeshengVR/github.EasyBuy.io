package com.Project.EasyBuy.User.Entry;

import java.util.Date;

public class Favority {
    private Number ID;
    private Number PRODUCTID;
    private String FILENAME;
    private Number CCODEID;
    private Date CREATETIME;
    private Number USERID;
    private Number PRICE;
    private String DESCRIPTION;

    @Override
    public String toString() {
        return "Favority{" +
                "ID=" + ID +
                ", PRODUCTID=" + PRODUCTID +
                ", FILENAME='" + FILENAME + '\'' +
                ", CCODEID=" + CCODEID +
                ", CREATETIME=" + CREATETIME +
                ", USERID=" + USERID +
                ", PRICE=" + PRICE +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }

    public Number getID() {
        return ID;
    }

    public void setID(Number ID) {
        this.ID = ID;
    }

    public Number getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(Number PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public Number getCCODEID() {
        return CCODEID;
    }

    public void setCCODEID(Number CCODEID) {
        this.CCODEID = CCODEID;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public Number getUSERID() {
        return USERID;
    }

    public void setUSERID(Number USERID) {
        this.USERID = USERID;
    }

    public Number getPRICE() {
        return PRICE;
    }

    public void setPRICE(Number PRICE) {
        this.PRICE = PRICE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Favority() {
    }

    public Favority(Number ID, Number PRODUCTID, String FILENAME, Number CCODEID, Date CREATETIME, Number USERID, Number PRICE, String DESCRIPTION) {
        this.ID = ID;
        this.PRODUCTID = PRODUCTID;
        this.FILENAME = FILENAME;
        this.CCODEID = CCODEID;
        this.CREATETIME = CREATETIME;
        this.USERID = USERID;
        this.PRICE = PRICE;
        this.DESCRIPTION = DESCRIPTION;
    }
}

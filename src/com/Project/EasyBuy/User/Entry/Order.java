package com.Project.EasyBuy.User.Entry;

import java.util.Date;

/**
 * 订单
 */
public class Order {
    private Number ID;
    private Number USERID;
    private String LOGINNAME;
    private String USERADDRESS;
    private Date CREATETIME;
    private Number COST;
    private String SERIALNUMBER;//序号

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

    public String getLOGINNAME() {
        return LOGINNAME;
    }

    public void setLOGINNAME(String LOGINNAME) {
        this.LOGINNAME = LOGINNAME;
    }

    public String getUSERADDRESS() {
        return USERADDRESS;
    }

    public void setUSERADDRESS(String USERADDRESS) {
        this.USERADDRESS = USERADDRESS;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public Number getCOST() {
        return COST;
    }

    public void setCOST(Number COST) {
        this.COST = COST;
    }

    public String getSERIALNUMBER() {
        return SERIALNUMBER;
    }

    public void setSERIALNUMBER(String SERIALNUMBER) {
        this.SERIALNUMBER = SERIALNUMBER;
    }

    public Order() {
    }

    public Order(Number ID, Number USERID, String LOGINNAME, String USERADDRESS, Date CREATETIME, Number COST, String SERIALNUMBER) {
        this.ID = ID;
        this.USERID = USERID;
        this.LOGINNAME = LOGINNAME;
        this.USERADDRESS = USERADDRESS;
        this.CREATETIME = CREATETIME;
        this.COST = COST;
        this.SERIALNUMBER = SERIALNUMBER;
    }
}

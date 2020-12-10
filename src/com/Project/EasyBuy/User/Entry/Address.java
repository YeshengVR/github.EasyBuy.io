package com.Project.EasyBuy.User.Entry;

import java.util.Date;

public class Address {
    private Number ID;
    private Number USERID;
    private String ADDRESS;
    private Date CREATETIME;
    private Number ISDEFAULT;
    private String REMARK;
    private Number PHONE;
    private Number YOUBIAN;
    private String NICKNAME;
    private String EMAIL;

    @Override
    public String toString() {
        return "Address{" +
                "ID=" + ID +
                ", USERID=" + USERID +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", CREATETIME=" + CREATETIME +
                ", ISDEFAULT=" + ISDEFAULT +
                ", REMARK='" + REMARK + '\'' +
                ", PHONE=" + PHONE +
                ", YOUBIAN=" + YOUBIAN +
                ", NICKNAME='" + NICKNAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }

    public Number getYOUBIAN() {
        return YOUBIAN;
    }

    public void setYOUBIAN(Number YOUBIAN) {
        this.YOUBIAN = YOUBIAN;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Number getPHONE() {
        return PHONE;
    }

    public void setPHONE(Number PHONE) {
        this.PHONE = PHONE;
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

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public Number getISDEFAULT() {
        return ISDEFAULT;
    }

    public void setISDEFAULT(Number ISDEFAULT) {
        this.ISDEFAULT = ISDEFAULT;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public Address() {
    }

    public Address(Number ID, Number USERID, String ADDRESS, Date CREATETIME, Number ISDEFAULT, String REMARK, Number PHONE, Number YOUBIAN, String NICKNAME, String EMAIL) {
        this.ID = ID;
        this.USERID = USERID;
        this.ADDRESS = ADDRESS;
        this.CREATETIME = CREATETIME;
        this.ISDEFAULT = ISDEFAULT;
        this.REMARK = REMARK;
        this.PHONE = PHONE;
        this.YOUBIAN = YOUBIAN;
        this.NICKNAME = NICKNAME;
        this.EMAIL = EMAIL;
    }
}

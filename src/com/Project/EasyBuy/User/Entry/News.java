package com.Project.EasyBuy.User.Entry;

import java.util.Date;

public class News {
    private Number ID;
    private String TITLE;
    private String CONTENT;
    private Date CREATETIME;

    public Number getID() {
        return ID;
    }

    public void setID(Number ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public News(Number ID, String TITLE, String CONTENT, Date CREATETIME) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
        this.CREATETIME = CREATETIME;
    }

    public News() {}
}

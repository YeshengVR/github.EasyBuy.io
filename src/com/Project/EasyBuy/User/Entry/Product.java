package com.Project.EasyBuy.User.Entry;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Number ID;
    private String NAME;
    private String DESCRIPTION;
    private Number price;
    private Number stock;
    private Number CATEGORYLEVEL1ID;
    private Number CATEGORYLEVEL2ID;
    private Number CATEGORYLEVEL3ID;
    private String FILENAME;
    private Number ISDELETE;
    private Date CREATEDATE;
    private Number CCODE;
    private Number SALES;

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", CATEGORYLEVEL1ID=" + CATEGORYLEVEL1ID +
                ", CATEGORYLEVEL2ID=" + CATEGORYLEVEL2ID +
                ", CATEGORYLEVEL3ID=" + CATEGORYLEVEL3ID +
                ", FILENAME='" + FILENAME + '\'' +
                ", ISDELETE=" + ISDELETE +
                ", CREATEDATE=" + CREATEDATE +
                ", CCODE=" + CCODE +
                ", SALES=" + SALES +
                '}';
    }

    public Product(Number ID, String NAME, String DESCRIPTION, Number price, Number stock, Number CATEGORYLEVEL1ID, Number CATEGORYLEVEL2ID, Number CATEGORYLEVEL3ID, String FILENAME, Number ISDELETE, Date CREATEDATE, Number CCODE, Number SALES) {
        this.ID = ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.price = price;
        this.stock = stock;
        this.CATEGORYLEVEL1ID = CATEGORYLEVEL1ID;
        this.CATEGORYLEVEL2ID = CATEGORYLEVEL2ID;
        this.CATEGORYLEVEL3ID = CATEGORYLEVEL3ID;
        this.FILENAME = FILENAME;
        this.ISDELETE = ISDELETE;
        this.CREATEDATE = CREATEDATE;
        this.CCODE = CCODE;
        this.SALES = SALES;
    }

    public Number getSALES() {
        return SALES;
    }

    public void setSALES(Number SALES) {
        this.SALES = SALES;
    }

    public Number getCCODE() {
        return CCODE;
    }

    public void setCCODE(Number CCODE) {
        this.CCODE = CCODE;
    }


    public Number getID() {
        return ID;
    }

    public void setID(Number ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getStock() {
        return stock;
    }

    public void setStock(Number stock) {
        this.stock = stock;
    }

    public Number getCATEGORYLEVEL1ID() {
        return CATEGORYLEVEL1ID;
    }

    public void setCATEGORYLEVEL1ID(Number CATEGORYLEVEL1ID) {
        this.CATEGORYLEVEL1ID = CATEGORYLEVEL1ID;
    }

    public Number getCATEGORYLEVEL2ID() {
        return CATEGORYLEVEL2ID;
    }

    public void setCATEGORYLEVEL2ID(Number CATEGORYLEVEL2ID) {
        this.CATEGORYLEVEL2ID = CATEGORYLEVEL2ID;
    }

    public Number getCATEGORYLEVEL3ID() {
        return CATEGORYLEVEL3ID;
    }

    public void setCATEGORYLEVEL3ID(Number CATEGORYLEVEL3ID) {
        this.CATEGORYLEVEL3ID = CATEGORYLEVEL3ID;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public Number getISDELETE() {
        return ISDELETE;
    }

    public void setISDELETE(Number ISDELETE) {
        this.ISDELETE = ISDELETE;
    }

    public Date getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(Date CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public Product() {
    }

}

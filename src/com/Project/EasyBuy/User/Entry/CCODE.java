package com.Project.EasyBuy.User.Entry;

public class CCODE {
    private Number ID;
    private Number PRODUCTID;
    private String PRODUCTCOLOR;
    private Number PRODUCTSTOCK;
    private String PRODUCTSPECI;
    private Number TypesID;

    @Override
    public String toString() {
        return "CCODE{" +
                "ID=" + ID +
                ", PRODUCTID=" + PRODUCTID +
                ", PRODUCTCOLOR='" + PRODUCTCOLOR + '\'' +
                ", PRODUCTSTOCK=" + PRODUCTSTOCK +
                ", PRODUCTSPECI='" + PRODUCTSPECI + '\'' +
                ", TypesID=" + TypesID +
                '}';
    }

    public Number getTypesID() {
        return TypesID;
    }

    public void setTypesID(Number typesID) {
        TypesID = typesID;
    }

    public CCODE(Number ID, Number PRODUCTID, String PRODUCTCOLOR, Number PRODUCTSTOCK, String PRODUCTSPECI, Number typesID) {
        this.ID = ID;
        this.PRODUCTID = PRODUCTID;
        this.PRODUCTCOLOR = PRODUCTCOLOR;
        this.PRODUCTSTOCK = PRODUCTSTOCK;
        this.PRODUCTSPECI = PRODUCTSPECI;
        TypesID = typesID;
    }

    public String getPRODUCTSPECI() {
        return PRODUCTSPECI;
    }

    public void setPRODUCTSPECI(String PRODUCTSPECI) {
        this.PRODUCTSPECI = PRODUCTSPECI;
    }

    public CCODE() {}

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

    public String getPRODUCTCOLOR() {
        return PRODUCTCOLOR;
    }

    public void setPRODUCTCOLOR(String PRODUCTCOLOR) {
        this.PRODUCTCOLOR = PRODUCTCOLOR;
    }

    public Number getPRODUCTSTOCK() {
        return PRODUCTSTOCK;
    }

    public void setPRODUCTSTOCK(Number PRODUCTSTOCK) {
        this.PRODUCTSTOCK = PRODUCTSTOCK;
    }
}

package com.Project.EasyBuy.User.Entry;

public class Category {
    private Number ID;
    private String NAME;
    private Number PARENTID;
    private Number TYPE;
    private String ICONCLASS;

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

    public Number getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(Number PARENTID) {
        this.PARENTID = PARENTID;
    }

    public Number getTYPE() {
        return TYPE;
    }

    public void setTYPE(Number TYPE) {
        this.TYPE = TYPE;
    }

    public String getICONCLASS() {
        return ICONCLASS;
    }

    public void setICONCLASS(String ICONCLASS) {
        this.ICONCLASS = ICONCLASS;
    }

    public Category() {}

    public Category(Number ID, String NAME, Number PARENTID, Number TYPE, String ICONCLASS) {
        this.ID = ID;
        this.NAME = NAME;
        this.PARENTID = PARENTID;
        this.TYPE = TYPE;
        this.ICONCLASS = ICONCLASS;
    }
}

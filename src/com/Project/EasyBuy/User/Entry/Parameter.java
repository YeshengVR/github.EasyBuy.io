package com.Project.EasyBuy.User.Entry;

import com.Project.EasyBuy.User.Util.PageEntry;

public class Parameter<T>{
    private Number userid;
    private Number categoryid;
    private Number historyid;
    private Number mixPrice;
    private Number maxPrice;
    private Boolean flag;
    private String sort;
    private String search;
    private Number currentpage;
    private PageEntry<T> pageEntry;
    private Number Productid;
    private String Order;
    private String cname;

    public Parameter() {}

    public Parameter(Number userid, Number categoryid, Number historyid, Number mixPrice, Number maxPrice, Boolean flag, String sort, String search, Number currentpage, PageEntry<T> pageEntry, Number productid, String order, String cname) {
        this.userid = userid;
        this.categoryid = categoryid;
        this.historyid = historyid;
        this.mixPrice = mixPrice;
        this.maxPrice = maxPrice;
        this.flag = flag;
        this.sort = sort;
        this.search = search;
        this.currentpage = currentpage;
        this.pageEntry = pageEntry;
        Productid = productid;
        Order = order;
        this.cname = cname;
    }

    public Number getUserid() {
        return userid;
    }

    public void setUserid(Number userid) {
        this.userid = userid;
    }

    public Number getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Number categoryid) {
        this.categoryid = categoryid;
    }

    public Number getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Number historyid) {
        this.historyid = historyid;
    }

    public Number getMixPrice() {
        return mixPrice;
    }

    public void setMixPrice(Number mixPrice) {
        this.mixPrice = mixPrice;
    }

    public Number getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Number maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Number getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Number currentpage) {
        this.currentpage = currentpage;
    }

    public PageEntry<T> getPageEntry() {
        return pageEntry;
    }

    public void setPageEntry(PageEntry<T> pageEntry) {
        this.pageEntry = pageEntry;
    }

    public Number getProductid() {
        return Productid;
    }

    public void setProductid(Number productid) {
        Productid = productid;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

package com.Project.EasyBuy.User.Util;


import java.io.Serializable;
import java.util.List;

public class PageEntry<T> implements Serializable {
    private Integer currentPage;
    private Integer totalPage;
    private Integer messagePage;
    private Integer totalMessage;
    private List<T> list;

    @Override
    public String toString() {
        return "PageEntry{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", messagePage=" + messagePage +
                ", totalMessage=" + totalMessage +
                ", list=" + list +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getMessagePage() {
        return messagePage;
    }

    public void setMessagePage(Integer messagePage) {
        this.messagePage = messagePage;
    }

    public Integer getTotalMessage() {
        return totalMessage;
    }

    public void setTotalMessage(Integer totalMessage) {
        this.totalMessage = totalMessage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageEntry(Integer currentPage, Integer totalPage, Integer messagePage, Integer totalMessage, List<T> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.messagePage = messagePage;
        this.totalMessage = totalMessage;
        this.list = list;
    }

    public PageEntry() {
    }
}

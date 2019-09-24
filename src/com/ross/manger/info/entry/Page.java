package com.ross.manger.info.entry;

import java.util.List;

public class Page {
    //数据库里的总条数
    private int pageSum;
    //分页时的总页数，按照数据库里的数据，分总共分多少页
    private int pageSize;
    //当前页码
    private int dangPage;
    //分页后每页显示的条数
    private int pageTiao=3;
    //分页后每
    private List <Project> getPageList;

    public Page() {
    }

    public Page(int pageSum, int pageSize, int dangPage, int pageTiao, List <Project> getPageList) {
        this.pageSum = pageSum;
        this.pageSize = pageSize;
        this.dangPage = dangPage;
        this.pageTiao = pageTiao;
        this.getPageList = getPageList;
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    public int getPageSize() {
        return this.pageSize=(pageSum % pageTiao==0)?(pageSum/pageSize):((pageSum/pageTiao)+1);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDangPage() {
        return dangPage;
    }

    public void setDangPage(int dangPage) {
        this.dangPage = dangPage;
    }

    public int getPageTiao() {
        return pageTiao;
    }

    public void setPageTiao(int pageTiao) {
        this.pageTiao = pageTiao;
    }

    public List <Project> getGetPageList() {
        return getPageList;
    }

    public void setGetPageList(List <Project> getPageList) {
        this.getPageList = getPageList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSum=" + pageSum +
                ", pageSize=" + pageSize +
                ", dangPage=" + dangPage +
                ", pageTiao=" + pageTiao +
                ", getPageList=" + getPageList +
                '}';
    }
}

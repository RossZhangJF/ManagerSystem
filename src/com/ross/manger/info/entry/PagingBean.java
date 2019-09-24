package com.ross.manger.info.entry;

import java.io.Serializable;
import java.util.List;

public class PagingBean<T> implements Serializable {
    private String page;	//当前页
    private int pageSize=0;	//分页数量
    private int count=0;		//总数据数
    private int allPage=0;	//总页数
    private int pageIndex=0;//当前页
    private int nextPage=0;	//下一页
    private int prevPage=0;	//上一页
    private int lastPage=0;	//尾页
    private List<T> listProject;

    public PagingBean(String page, int pageSize, int count) {
        super();
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
        initAllPage();	//初始化总页数
        initPageIndex();//初始化当前页
        initPrevPage();	//初始化上一页
        initNextPage();	//初始化下一页
        initEndPage();	//初始化尾页
    }

    private void initEndPage() {
        lastPage = allPage;
    }

    private void initNextPage() {
        //如果当前页是尾页，则下一页也为尾页，其余都为当前页+1
        if(pageIndex>=allPage){
            nextPage = allPage;
        }else{
            nextPage = pageIndex+1;
        }
    }

    private void initPrevPage() {
        //如果当前页为1，则上一页也为1，其余都为当前页-1
        if(pageIndex>1){
            prevPage = pageIndex-1;
        }else{
            prevPage = 1;
        }
    }

    private void initPageIndex() {
        if(page!=null&&page.equals("")){
            pageIndex = Integer.parseInt(page);
        }else{
            pageIndex = 1;
            pageIndex = Integer.parseInt(page);
        }
    }

    private void initAllPage() {
        if(count%pageSize==0){
            allPage = count/pageSize;
        }else{
            allPage = count/pageSize+1;
        }

    }

    public PagingBean(String page, int pageSize, int count, int allPage, int pageIndex, int nextPage, int prevPage, int lastPage, List <T> listProject) {
        this.page = page;
        this.pageSize = pageSize;
        this.count = count;
        this.allPage = allPage;
        this.pageIndex = pageIndex;
        this.nextPage = nextPage;
        this.prevPage = prevPage;
        this.lastPage = lastPage;
        this.listProject = listProject;
    }

    public PagingBean() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List <T> getListProject() {
        return listProject;
    }

    public void setListProject(List <T> listProject) {
        this.listProject = listProject;
    }

    @Override
    public String toString() {
        return "PagingBean{" +
                "page='" + page + '\'' +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", allPage=" + allPage +
                ", pageIndex=" + pageIndex +
                ", nextPage=" + nextPage +
                ", prevPage=" + prevPage +
                ", lastPage=" + lastPage +
                ", listProject=" + listProject +
                '}';
    }
}

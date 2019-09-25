package com.ross.manger.info.entry;

import java.util.List;

/**
 * 这是一个分页的的工具
 */
public class Page<T> {
    /**当前页*/
    private int pageNow;
    /**每页记录数*/
    private int pageSize;

    /**首页*/
    private int first = 1;
    /**上一页*/
    private int prev;
    /**下一页*/
    private int next;
    /**最后一页*/
    private int last;
    /**总记录数*/
    private int totalNum;
    /**总页数*/
    private int totalPage;

    /**开始显示的位置*/
    private int begin;
    /**结束显示的位置*/
    private int end;

    /**当前页面要显示的数据*/
    private List<T> data;

    public Page() {
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List <T> getData() {
        return data;
    }

    public void setData(List <T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNow=" + pageNow +
                ", pageSize=" + pageSize +
                ", first=" + first +
                ", prev=" + prev +
                ", next=" + next +
                ", last=" + last +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", begin=" + begin +
                ", end=" + end +
                ", data=" + data +
                '}';
    }
}

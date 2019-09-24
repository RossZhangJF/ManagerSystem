package com.ross.manger.info.entry;

import java.io.Serializable;
import java.util.List;

public class PagingBean<T> implements Serializable {
    private int pageNum;//页面传过来的 每页显示的数量
    private int pageSize; //在后台初始化，也可以动态传递  总共有多少页
    private int startIndex;//每页的起始索引号 计算出来的  开始的索引
    private int totalPage;//依据页大小和总记录数计算出来的  总共有多少页
    private int totalRecord;//查询出来的
    private List <T> result;//结果

    //分页的滚动条
    private int start=1;
    private int end=10;

    public PagingBean(int pageNum, int pageSize, int totalRecord,List <T> result) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.result=result;
        //计算startIndex
        this.startIndex=(this.pageNum-1)*this.pageSize;

        //计算总页数
        if(this.totalRecord%this.pageSize==0){
            this.totalPage=this.totalRecord/this.pageSize;
        }else{
            this.totalPage=this.totalRecord/this.pageSize+1;
        }

        //计算滚动条
        //计算总页数小于10 ，

        if(this.totalPage<=10){
            this.end=this.totalPage;
        }else{

            //35页
            this.start=this.pageNum-5;
            this.end=this.pageNum+4;

            if(this.start<1){
                this.end=10;
                this.start=1;
            }
            if(this.end>this.totalPage){
                this.end=this.totalPage;
                this.start=this.totalPage-9;
            }
        }
    }

    public PagingBean() {
    }

    @Override
    public String toString() {
        return "PagingBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", totalPage=" + totalPage +
                ", totalRecord=" + totalRecord +
                ", result=" + result +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List <T> getResult() {
        return result;
    }

    public void setResult(List <T> result) {
        this.result = result;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

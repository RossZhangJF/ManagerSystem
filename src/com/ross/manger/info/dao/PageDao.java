package com.ross.manger.info.dao;

import com.ross.manger.info.entry.Project;

import java.util.List;

public interface PageDao {
    //获取数据库总条数
    public int SumSize();
    //获取每次分页要显示的数据,
    public List <Project> getPageList(int dangPage, int pageSize);
}

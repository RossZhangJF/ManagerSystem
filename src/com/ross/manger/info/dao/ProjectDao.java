package com.ross.manger.info.dao;

import com.ross.manger.info.entry.Project;

import java.util.List;

public interface ProjectDao {
    /**
     * 得到所有的数据
     * @return 返回一个List集合
     */
    public List <Project> getProjectAll();

    /**
     * 根据登录者ID得到一个List集合数据
     * @param stuId  当前的登录者
     * @return 返回一个list集合
     */
    public List<Project> getProjectById(Integer stuId);
    /**
     * 简单的分页查询
     * @param pageNum 记录行的偏移量
     * @param pageSize 记录行的最大数目。
     * @return 返回一个project的List集合
     */
    public List <Project> getProjectByStuIdDataPaging(Integer stuId, int pageNum, int pageSize) ;

    /**
     * 从数据库中查询所有的数据，进行分页
     * @param pageNum 拿到的当前页数
     * @param pageSize 每页的记录数
     * @return
     */
    public List <Project> getProjectAllDataPaging( int pageNum, int pageSize) ;

    /**
     * 计算每页的起始位置
     * @return 返回起始位置
     */
    public int getAllRecord() ;
}

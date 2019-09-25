package com.ross.manger.info.service;

import com.ross.manger.info.entry.Project;

import java.util.List;

public interface ProjectService {
    public List <Project> getProjectAllService();
    public List<Project> getProjectByIdService(Integer stuId);
    public List <Project> getProjectByStuIdDataPagingService(Integer stuId,int pageNum, int pageSize) ;
    public List <Project> getProjectAllDataPagingService(int pageNum, int pageSize) ;
    public int getAllRecordService() ;
}

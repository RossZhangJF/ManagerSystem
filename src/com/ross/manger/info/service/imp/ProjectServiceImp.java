package com.ross.manger.info.service.imp;

import com.ross.manger.info.dao.ProjectDao;
import com.ross.manger.info.dao.imp.ProjectDaoImp;
import com.ross.manger.info.entry.Project;
import com.ross.manger.info.service.ProjectService;

import java.util.List;

public class ProjectServiceImp implements ProjectService {
    private static ProjectDao proDao=new ProjectDaoImp();
    @Override
    public List <Project> getProjectAllService() {
        return proDao.getProjectAll();
    }

    @Override
    public List <Project> getProjectByIdService(Integer stuId) {
        return proDao.getProjectById(stuId);
    }

    @Override
    public List <Project> findUserBySimplePageService(Integer stuId, int pageNum, int pageSize) {
        return proDao.findUserBySimplePage(stuId,pageNum,pageSize);
    }

    @Override
    public int findTotalRecordService() {
        return proDao.findTotalRecord();
    }
}

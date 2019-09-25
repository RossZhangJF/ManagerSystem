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
    public List <Project> getProjectByStuIdDataPagingService(Integer stuId, int pageNum, int pageSize) {
        return proDao.getProjectByStuIdDataPaging(stuId,pageNum,pageSize);
    }

    @Override
    public List <Project> getProjectAllDataPagingService(int pageNum, int pageSize) {
        return proDao.getProjectAllDataPaging(pageNum,pageSize);
    }

    @Override
    public List <Project> getProjectLikeProNameService(String proName, Integer proState) {
        return proDao.getProjectLikeProName(proName,proState);
    }

    @Override
    public List <Project> getProjectLikeAllService(String proName) {
        return proDao.getProjectLikeAll(proName);
    }

    @Override
    public int getAllRecordService() {
        return proDao.getAllRecord();
    }

    /*public static void main(String[] args) {
        ProjectServiceImp p=new ProjectServiceImp();
        int a=p.getAllRecordService();
        System.out.println(a);
    }*/
}

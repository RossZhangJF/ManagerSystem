package com.ross.manger.info.dao.imp;

import com.ross.manger.info.dao.ProjectDao;
import com.ross.manger.info.entry.Project;

import java.util.List;

public class ProjectDaoImp extends DaoImp<Project> implements ProjectDao {
    @Override
    public List <Project> getProjectAll() {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id ; ";
        List<Project> list=getAll(Project.class,sql);
        if (list != null)
            return list;
        return null;
    }

    @Override
    public List <Project> getProjectById(Integer stuId) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                " where pro.pro_person = ? ; ";
        List<Project> list= getAll(Project.class,sql,stuId);
        if (list != null)
            return list;
        return null;
    }

    @Override
    public List <Project> getProjectByStuIdDataPaging(Integer stuId, int pageNum, int pageSize) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                " where pro.pro_person = ? limit ?,? ; ";
        List<Project> list=getAll(Project.class,sql,stuId,pageNum,pageSize);
        if (list!=null)
            return list;
        return null;
    }

    @Override
    public List <Project> getProjectAllDataPaging(int pageNum, int pageSize) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                "  limit ?,? ; ";
        List<Project> list=getAll(Project.class,sql,pageNum,pageSize);
        if (list!=null)
            return list;
        return null;
    }

    @Override
    public List <Project> getProjectLikeProName(String proName,Integer proState) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                " where pro.pro_name like ? and pro.sta_id = ?; ";
        List<Project> list= getAll(Project.class,sql,"%"+proName+"%",proState);
        if (list != null)
            return list;
        return null;
    }

    @Override
    public List <Project> getProjectLikeAll(String proName) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                " where pro.pro_name like ? ; ";
        List<Project> list= getAll(Project.class,sql,"%"+proName+"%");
        if (list != null)
            return list;
        return null;
    }

    @Override
    public int getAllRecord() {
        String sql="select  count(*)  from project ;";
        int total=getAllDataCount(sql);
        if (total != 0)
            return total;
        return 0;
    }

    /*public static void main(String[] args) {
        ProjectDaoImp p=new ProjectDaoImp();
//        int num=p.getAllRecord();
//        System.out.println(num);
        List<Project> list=p.getProjectLikeProName("九");
        System.out.println(list);
    }*/
}

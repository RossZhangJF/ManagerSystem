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
    public List <Project> findUserBySimplePage(Integer stuId, int pageNum, int pageSize) {
        String sql=" select pro_id proId,pro_name proName,stu_name proPerson,pro_state proState,pro_date proDate " +
                " from project pro inner join student stu on pro.pro_person = stu.stu_id " +
                " where pro.pro_person = ? limit ?,? ; ";
        List<Project> list=getAll(Project.class,sql,stuId,pageNum,pageSize);
        if (list!=null)
            return list;
        return null;
    }

    @Override
    public int findTotalRecord() {
        String sql="select  count(*)  from project where pro_person = ? GROUP BY pro_person ;";
        int total=getTotal(sql,3);
        if (total != 0)
            return total;
        return 0;
    }

    /*public static void main(String[] args) {
        ProjectDaoImp p=new ProjectDaoImp();
        int num=p.findTotalRecord();
        System.out.println(num);
    }*/
}

package com.ross.manger.info.dao.imp;

import com.ross.manger.info.dao.Dao;
import com.ross.manger.info.entry.Student;
import com.ross.manger.info.utils.BaseConn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DaoImp<T> implements Dao<T> {
    private Connection connection=null;
    private QueryRunner queryRunner=null;
    {
        connection= BaseConn.getConnection();
        queryRunner=new QueryRunner();
    }
    @Override
    public T get(Class clazz, String sql, Object ... objs) {
        T t=null;
        try {
            t=  queryRunner.query(connection,sql,new BeanHandler <T>(clazz),objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (t!=null)
            return t;
        return null;
    }

    @Override
    public boolean update(String sql, Object... objs) {
        int row=0;
        try {
           row= queryRunner.update(connection,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row==0?false:true;
    }

    @Override
    public List <T> getAll(Class <T> clazz, String sql, Object... objs) {
        List<T> list=null;
        try {
            list=queryRunner.query(connection,sql,new BeanListHandler <T>(clazz),objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list!=null)
            return  list;
        return null;
    }

    @Override
    public int getTotal(String sql, Object ... id) {
        Long total=0L;
        try {
           total =  queryRunner.query(connection,sql,new ScalarHandler <>(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (total != 0L)
            return total.intValue();
        return 0;
    }

    @Override
    public int getAllDataCount(String sql) {
        Long total=0L;
        try {
            total =  queryRunner.query(connection,sql,new ScalarHandler <>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (total != 0L)
            return total.intValue();
        return 0;
    }

    /*public static void main(String[] args) {
        String sql="select stu_id stuId,stu_no stuNo,stu_name stuName,stu_sex stuSex," +
                " stu_age stuAge,stu_phone stuPhone,stu_idcard stuIdCard," +
                " stu_email stuEmail,stu_addr stuAddr,stu_grade stuGrade," +
                " stu_class stuClass,stu_img stuImg,stu_pwd stuPwd,auth_id authId from student " +
                " where stu_no = ? or stu_idcard = ?;";
        DaoImp<Student> daoImp=new DaoImp<>();
        Student student=daoImp.get(Student.class,sql,"201301003","201301003");
        System.out.println(student);
    }*/
}

package com.ross.manger.info.dao.imp;

import com.ross.manger.info.dao.Dao;
import com.ross.manger.info.dao.StudentDao;
import com.ross.manger.info.entry.Student;

public class StudentDaoImp extends DaoImp<Student> implements StudentDao {
    @Override
    public Student getStudent(String username, String password) {
        String sql="select stu_id stuId,stu_no stuNo,stu_name stuName,stu_sex stuSex," +
                " stu_age stuAge,stu_phone stuPhone,stu_idcard stuIdCard," +
                " stu_email stuEmail,stu_addr stuAddr,stu_grade stuGrade," +
                " stu_class stuClass,stu_img stuImg,stu_pwd stuPwd,auth_id authId from student " +
                " where (stu_no = ? or stu_idcard = ?) and stu_pwd = ?;";
        Student student=get(Student.class,sql,username,username,password);
        if (student!=null)
            return student;
        return null;
    }

    @Override
    public Student getStudentByUserName(String username) {
        String sql="select stu_id stuId,stu_no stuNo,stu_name stuName,stu_sex stuSex," +
                " stu_age stuAge,stu_phone stuPhone,stu_idcard stuIdCard," +
                " stu_email stuEmail,stu_addr stuAddr,stu_grade stuGrade," +
                " stu_class stuClass,stu_img stuImg,stu_pwd stuPwd,auth_id authId from student " +
                " where stu_no = ? or stu_idcard = ?;";
        Student student=get(Student.class,sql,username,username);
        if (student!=null)
            return student;
        return null;
    }

    /*public static void main(String[] args) {
        StudentDaoImp s=new StudentDaoImp();
        Student student=s.getStudentByUserName("201301003");
        System.out.println(student);
    }*/
}

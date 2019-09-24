package com.ross.manger.info.service.imp;

import com.ross.manger.info.dao.StudentDao;
import com.ross.manger.info.dao.imp.StudentDaoImp;
import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.StudentService;

public class StudentServiceImp implements StudentService {
    private StudentDao stuDao=new StudentDaoImp();
    @Override
    public Student getStudentService(String username, String password) {
        return stuDao.getStudent(username,password);
    }

    @Override
    public Student getStudentByUserNameService(String username) {
        return stuDao.getStudentByUserName(username);
    }

    /*public static void main(String[] args) {
        StudentServiceImp s=new StudentServiceImp();
        Student student= s.getStudentByUserNameService("201301003");
        System.out.println(student);
    }*/
}

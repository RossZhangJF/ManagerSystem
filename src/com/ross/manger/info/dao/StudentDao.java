package com.ross.manger.info.dao;

import com.ross.manger.info.entry.Student;

public interface StudentDao {
    public Student getStudent(String username, String password);
    public Student getStudentByUserName(String username);
}

package com.ross.manger.info.service;

import com.ross.manger.info.entry.Student;

public interface StudentService {
    public Student getStudentService(String username, String password);
    public Student getStudentByUserNameService(String username);
}

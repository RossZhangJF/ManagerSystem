package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.StudentService;
import com.ross.manger.info.service.imp.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private static StudentService stuService=new StudentServiceImp();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("我是登录的Servlet");
        String nameCookie="",pwdCookie="";
        String uName=request.getParameter("username");
        String uPwd=request.getParameter("password");
        String isPwd=request.getParameter("isPwd");
        Student student=stuService.getStudentService(uName,uPwd);
        if (student !=null){
            HttpSession session=request.getSession();
            session.setAttribute("student",student);
            session.setMaxInactiveInterval(60*60);
            response.sendRedirect("main.html");
        }else {
            response.sendRedirect("login3.jsp");
        }
    }
}

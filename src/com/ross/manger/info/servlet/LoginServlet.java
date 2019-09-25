package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.StudentService;
import com.ross.manger.info.service.imp.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        String isPwd=request.getParameter("isPwd");  //是否自动登录
        Student student=stuService.getStudentService(uName,uPwd);
        if (student !=null){
            if(isPwd==null) {//未勾选自动登录
                Cookie cookie = new Cookie("auto", null);
                cookie.setMaxAge(60*60*24);//cookie有效时间
                cookie.setPath(request.getContextPath()+"/");
                response.addCookie(cookie);
            }else {//勾选自动登录
                Cookie cookie = new Cookie("auto", uName+"_"+uPwd);
                cookie.setMaxAge(60*60*24);//cookie有效时间
                cookie.setPath(request.getContextPath()+"/");
                response.addCookie(cookie);
            }
            HttpSession session=request.getSession();
            session.setAttribute("student",student);
//            session.setMaxInactiveInterval(60*60);
            response.sendRedirect("main.html");
        }else {
            response.sendRedirect("login3.jsp");
        }
    }
}

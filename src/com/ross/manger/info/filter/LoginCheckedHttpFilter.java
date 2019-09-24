package com.ross.manger.info.filter;

import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.StudentService;
import com.ross.manger.info.service.imp.StudentServiceImp;
import com.ross.manger.info.utils.HTTPFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCheckedHttpFilter extends HTTPFilter {
    private StudentService stuService=new StudentServiceImp();
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("我是登录的拦截器filter");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Student student=stuService.getStudentByUserNameService(username);
//        System.out.println(student);
        if (student!=null ) {
            if (username.equals(student.getStuNo()) || username.equals(student.getStuIdCard())){
//                System.out.println(546456);
                if(password.equals(student.getStuPwd())){
                    chain.doFilter(request,response); return;
                }else{
                    request.setAttribute("message","你输入的帐号或密码不正确，请重新输入。");
//                    response.getWriter().write("你输入的帐号或密码不正确，请重新输入。");
                    request.getRequestDispatcher("login3.jsp").forward(request,response);
//                    response.sendRedirect("login3.jsp");
                    return;
                }
            }else{
                request.setAttribute("message","你输入的帐号或密码不正确，请重新输入。");
                response.sendRedirect("login3.jsp");return;
            }
        }else{
            request.setAttribute("message","你输入的帐号或密码不正确，请重新输入。");
            response.sendRedirect("login3.jsp");return;
        }
    }
}

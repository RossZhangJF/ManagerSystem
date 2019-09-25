package com.ross.manger.info.filter;

import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.StudentService;
import com.ross.manger.info.service.imp.StudentServiceImp;
import com.ross.manger.info.utils.CookieUtil;
import com.ross.manger.info.utils.HTTPFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAutoFilter extends HTTPFilter {
    private static StudentService stuService=new StudentServiceImp();
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request.getRequestURI().contains("login")) {//如果访问login,直接放行
            chain.doFilter(request, response);
            return;
        }else {
            Student student = (Student) request.getSession().getAttribute("student");
            System.out.println("student="+student);
            if(student.getStuNo()==null && student.getStuIdCard() == null) {//sesion中没有，去Cookie中找
                String val = CookieUtil.getCookieValByKey("auto", request);
                System.out.println(val);
                if(val!= null&& !val.equals("")) {
                    String name = val.split("_")[0];
                    String pass = val.split("_")[1];

                    Student stu=stuService.getStudentService(name,pass);
                    if(stu!=null) {//重新验证登录
                        request.getSession().setAttribute("student", stu);//登录成功，放入Session，并放行
                        chain.doFilter(request, response);
                        return;
                    }else {//验证失败，重新登录
                        response.sendRedirect("login.jsp");
                    }
                }else {//Cookie中也没有，第一次访问，跳转登录页面
                    response.sendRedirect("login.jsp");
                }
            }else {//session中有，放行
                chain.doFilter(request, response);
                return;
            }
        }
    }
}

package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.Page;
import com.ross.manger.info.service.PageService;
import com.ross.manger.info.service.imp.PageServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //取得jsp页码传进来的当前页码
        Integer d=1;
        String dang=request.getParameter("dangPage");
        System.out.println("dang Page yemian"+dang);
        if (dang!=null) {
            d=Integer.parseInt(dang);
        }
//        PageBiz pb=new PageBizImpl();
        PageService pb=new PageServiceImp();
        Page page=pb.getPage(d);
        request.setAttribute("page", page);
        request.getRequestDispatcher("myindex.jsp").forward(request, response);
    }
}

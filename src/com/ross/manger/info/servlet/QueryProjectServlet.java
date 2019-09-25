package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.Page;
import com.ross.manger.info.entry.Project;
import com.ross.manger.info.service.ProjectService;
import com.ross.manger.info.service.imp.PageService;
import com.ross.manger.info.service.imp.ProjectServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryProjectServlet")
public class QueryProjectServlet extends HttpServlet {
    private static ProjectService proService = new ProjectServiceImp();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("我是查询servlet");
        List<Project> projects = null;
        String projectName = req.getParameter("proName");//项目名称
        String proposerNameValue = req.getParameter("proposerName"); //获得下拉框选中的值  1 = 全部； 2 = 其他
        Integer proStateValue=Integer.parseInt(req.getParameter("proState"));
//        Integer proStateValue=new Integer(req.getParameter("proState")); // 1 = 全部； 2 = 已审核；3=已结项；4=未审核
       switch (proStateValue){
           case 1:
               projects= proService.getProjectLikeAllService(projectName);
               break;
           case 2:
               projects= proService.getProjectLikeProNameService(projectName,1);
               break;
           case 3:
               projects= proService.getProjectLikeProNameService(projectName,2);
               break;
           case 4:
               projects= proService.getProjectLikeProNameService(projectName,3);
               break;
           default:
               break;
       }

        //取得jsp页码传进来的当前页码
        int d=0;
        String dang=req.getParameter("dangPage");
        System.out.println(dang+"newPage");

        if (dang != null) {
            d=Integer.parseInt(dang);
        }
        Page page= PageService.paging(d,10);

        if (page != null){
            System.out.println("page:"+page);
            req.setAttribute("pageList", page);
            req.getRequestDispatcher("search.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("error.html").forward(req, resp);
        }
//        System.out.println(projects);
    }
}

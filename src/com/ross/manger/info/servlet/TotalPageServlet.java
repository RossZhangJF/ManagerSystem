package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.Page;
import com.ross.manger.info.service.imp.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TotalPageServlet")
public class TotalPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(44666);
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");

//        PrintWriter out = response.getWriter();
        //取得jsp页码传进来的当前页码
        int d=0;
        String dang=request.getParameter("dangPage");
        System.out.println(dang+"dangqang");

        if (dang != null) {
            d=Integer.parseInt(dang);
        }
        Page page= PageService.paging(d,12);
        if (page!=null){
            System.out.println("page:"+page);
            request.setAttribute("pageList", page);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("error.html").forward(request, response);
        }
        /*// JSON格式数据解析对象
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject=new JSONObject();

        HttpSession session=request.getSession();
        Student student= (Student) session.getAttribute("student");
//        System.out.println(student.getStuId()+"789");
//        List<Project> project= proService.getProjectByIdService(student.getStuId());
        List <Project> project = proService.findUserBySimplePageService(student.getStuId(),0,9);
//        往JSON 添加一个List 集合
        jsonArray.addAll(project);
        String jsonString=jsonArray.toString();//将jisn转换为字符串

        //总记录数
        int count=proService.findTotalRecordService();
//        System.out.println(totalRecord);
        PagingBean<Project> pagingBean=new PagingBean <Project>(project,"1",6,count);   //分页POJO

        if (project != null){
            request.setAttribute("project",project);
            response.getWriter().print(jsonString);//返回json信息
            request.getRequestDispatcher("search.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("error.html").forward(request,response);
        }*/
    }

}

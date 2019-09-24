package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.PagingBean;
import com.ross.manger.info.entry.Project;
import com.ross.manger.info.entry.Student;
import com.ross.manger.info.service.ProjectService;
import com.ross.manger.info.service.imp.ProjectServiceImp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TotalPageServlet")
public class TotalPageServlet extends HttpServlet {
    private static ProjectService proService =new ProjectServiceImp();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("我是谁");
        // JSON格式数据解析对象
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
        }
    }

}

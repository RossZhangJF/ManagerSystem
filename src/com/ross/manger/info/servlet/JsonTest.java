package com.ross.manger.info.servlet;

import com.ross.manger.info.entry.TestA;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JsonTest")
public class JsonTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public JsonTest() {
        super();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpage = request.getParameter("currpage");
        String limit = request.getParameter("limit");
        System.out.println("-------"+cpage);
        List <TestA> list = new ArrayList <TestA>();
        for(int i = (Integer.parseInt(cpage)-1)*Integer.parseInt(limit);
            i < (Integer.parseInt(cpage)-1)*Integer.parseInt(limit)+Integer.parseInt(limit); i++) {
            TestA a = new TestA(i,"test"+i);
            list.add(a);
        }
        JSONArray jarray = JSONArray.fromObject(list);

        response.getWriter().write(jarray.toString());
    }
}

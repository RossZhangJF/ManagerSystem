<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/9/24
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
这是Page：${page}
<c:if test="${page==null }">
    <% response.sendRedirect("PageServlet"); %>
</c:if>

<table border="1px solid bluck">
    <caption>学生信息实现分页</caption>
    <tr><td>学生编号</td><td>学生姓名</td><td>学生年龄</td><td>学生班级</td><td>学生性别</td></tr>
    <c:forEach var="p" items="${page.getPageList }">
        <tr>
            <td>${p.proID }</td>
            <td>${p.proName }</td>
            <td>${p.proPerson }</td>
            <td>${p.proState }</td>
            <td>${p.proDate }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            现在是${page.dangPage}/${page.pageSize}页
            <a href="PageServlet?dangPage=1">首页</a>
            <c:if test="${page.dangPage>1}">
                <a href="PageServlet?dangPage=${page.dangPage-1}">上一页</a>
            </c:if>
            <c:if test="${page.dangPage < page.pageSize}">
                <a href="PageServlet?dangPage=${page.dangPage+1}">下一页</a>
            </c:if>
            <a href="PageServlet?dangPage=${page.pageSize }">末页</a>
        </td>
    </tr>
</table>
</body>
</html>
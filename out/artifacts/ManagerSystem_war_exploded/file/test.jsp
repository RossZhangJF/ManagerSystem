<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/9/22
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>所有的用户列表</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>爱好</th>
        <th>类型</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageBean.result }" var="user" varStatus="vs">
        <tr>
            <td>${vs.count }</td>
            <td>${user.name }</td>
            <td>${user.gender }</td>
            <td>${user.birthday }</td>
            <td>${user.cellphone }</td>
            <td>${user.email}</td>
            <td>${user.preference}</td>
            <td>${user.type}</td>
            <td>${user.description }</td>
            <td><a href="">编辑</a>|
                <a href="">删除</a>|
                <a href="">详情</a></td>
        </tr>
    </c:forEach>
</table>
<c:url var="baseUrl" value="">
    <%-- <c:param name="" value=""></c:param> --%>
</c:url>


<c:if test="${pageBean.pageNum>1}">
    <a href="1">首页</a>
    <a href="">上一页</a>
</c:if>

<c:forEach begin="${pageBean.start }" end="${pageBean.end}" var="num">
    <a href="">${num }</a>
</c:forEach>

<c:if test="${pageBean.pageNum<pageBean.totalPage}">
    <a href="">下一页</a>
    <a href="">尾页</a>
</c:if>
当前${pageBean.pageNum}页 总${pageBean.totalPage}页数 总记录${pageBean.totalRecord}条数
跳转到
<input type="text" size="6" name="num"  id="pageNum" onkeydown="changePage02(event)">
<input type="button" id="pageButton" value="Go" onclick="changePage01()"/>
<select id="select">
    <c:forEach begin="0" end="30" step="5" var="size">
        <option value="${size }" >${size }</option>
    </c:forEach>
</select>

<script type="text/javascript">
    //获取到输入的页码

    function changePage01(){
        var doc=document.getElementById("pageNum");
        //获取到select
        var select=document.getElementById("select");
        //获取到被选中的索引
        var index=select.selectedIndex ;
        //获取到被选中的索引值
        var pageSize=select.options[index].value;

        document.getElementById("size_")
        var pageNum=doc.value;
        window.location.href="${baseUrl}"+pageNum+"&pageSize="+pageSize;

    }

    function changePage02(event){
        var doc=document.getElementById("pageNum");
        var pageNum=doc.value;
        if(pageNum){
            if(event.keyCode==13){
                window.location.href="${baseUrl}"+pageNum;
            }
        }

    }

</script>
</body>
</html>

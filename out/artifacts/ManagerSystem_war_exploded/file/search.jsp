<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/9/21
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript" src="../editor/kindeditor.js"></script>

    <script type="text/javascript">
        KE.show({
            id : 'content7',
            cssPath : './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function(e) {

            $(".select3").uedSelect({
                width : 152
            });
        });

        $(document).ready(function() {
            $(".scbtn1").click(function()
            {
                if( $(".seachform2").hasClass("hideclass") )
                {
                    $(".seachform2").removeClass("hideClass");
                }
                else
                {
                    $(".seachform2").addClass("hideClass");
                }
            });

            $(".scbtn1").click(function(){
                $(".seachform2").fadeIn(200);
            });
        })
        /*
            var totalPage;
            if (window.XMLHttpRequest){
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                totalPage=new XMLHttpRequest();
            }else{
                // IE6, IE5 浏览器执行代码
                totalPage=new ActiveXObject("Microsoft.XMLHTTP");
            }
            totalPage.onreadystatechange=function()
            {
                if (totalPage.readyState==4  ){
                    if(totalPage.status==200){
                        var result=totalPage.responseText;
                        var
                        console.log(result);
                    }
                }
            }
            totalPage.open("get","totalPageServlet",true);
            totalPage.send(null);

            });
        $(document).ready(function(){
            $.ajax({
                dataType:"json",    //数据类型为json格式
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                type:"post",
                url:"totalPageServlet",
                statusCode: {
                    404: function() {
                        alert('提交地址url未发现。 ');
                    }
                },
                success:function(data,textStatus){
                    //alert(data);//对象
                    alert("返回状态："+textStatus);//状态
                    var objs=eval(data);
                    var obj = objs[0];

                    var tbody=$("#tbody");
                    var categorys = obj.categorys;
                    var proId;var proName;var proPerson;var proState;var proDate;
                    for(var i=0; i  &lt;  categorys.length; i ++ ){
                        proId = categorys[i].type;
                        var subObjects = categorys[i].subObjects;
                        var len = subObjects.length;
                        tbody.append("&lt;tr> 我是谁啊。。。我在干嘛 &lt;/tr>");
                        for(var j=1;j &lt; len;j++){
                            tbody.append();
                        }
                    }
                }
            });
        })
        */
    </script>
</head>

<body class="sarchbody">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">系统设置</a></li>
    </ul>
</div>

<div class="formbody">
<%--    ${pageList}--%>
    <c:if test="${ pageList == null }">
        <% response.sendRedirect("totalPageServlet"); %>
    </c:if>

    <div id="usual1" class="usual">


        <form action="queryProject" method="post">
            <ul class="seachform1">

                <li><label>项目名称</label><input name="proName" type="text" class="scinput1" /></li>
                <li><label>申请人</label>
                    <div class="vocation">
                        <select name="proposerName" class="select3">
                            <option value="1">全部</option>
                            <option value="2">其他</option>
                        </select>
                    </div>
                </li>

                <li><label>项目状态</label>
                    <div class="vocation">
                        <select name="proState" class="select3">
                            <option value="1">全部</option>
                            <option value="2">已审核</option>
                            <option value="3">已结项</option>
                            <option value="4">未审核</option>
                        </select>
                    </div>
                </li>


            </ul>
<%--
            <ul class="seachform2">

                <li><label>项目编号</label><input name="proId" type="text" class="scinput1" /></li>
                <li><label>项目类型</label>
                    <div class="vocation">
                        <select name="proType" class="select3">
                            <option value="1">全部</option>
                            <option value="2">其他</option>
                        </select>
                    </div>
                </li>

                <li><label>项目领域</label>
                    <div class="vocation">
                        <select name="proField" class="select3">
                            <option value="1">全部</option>
                            <option value="2">其他</option>
                        </select>
                    </div>
                </li>

                <li><label>立项部门</label><input name="proDepartment" type="text" class="scinput1" /></li>
                <li><label>经费范围</label><input name="proExpenditure" type="text" class="scinput1" /></li>
                <li><label>一</label><input name="" type="text" class="scinput1" /></li>
                <li><label>负责人</label><input name="" type="text" class="scinput1" /></li>
                <li><label>立项时间</label><input name="" type="text" class="scinput1" /></li>
                <li><label>一</label><input name="" type="text" class="scinput1" /></li>


            </ul>
--%>
            <ul class="seachform1">
                <li class="sarchbtn"><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/>   <input name="" type="button" class="scbtn1" value="更多条件"/>   <input name="" type="button" class="scbtn2" value="导出"/></li>
            </ul>
        </form>
        <div class="formtitle"><span>项目列表</span></div>
        <table class="tablelist">
            <thead>
            <tr>
                <th><input name="" type="checkbox" value="" checked="checked"/></th>
                <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
                <th>项目名称</th>
                <th>申请人</th>
                <th>发布时间</th>
                <th>是否审核</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody >

                <c:forEach items="${pageList.data }" var="result" >
                    <tr id="tbody">
                        <td><input name="" type="checkbox" value="" /></td>
                        <td>${result.proID}</td>
                        <td>${result.proName}</td>
                        <td>${result.proPerson}</td>
                        <td>${result.proDate}</td>
                        <td>${result.proState}</td>
                        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink"> 删除</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="pagin">
            <div class="message">现在是${pageList.pageNow}/${pageList.totalPage}页</div>
            <ul class="paginList">
                <li class="paginItem"><a href="totalPageServlet?dangPage=1"><span class="pagepre">首页</span></a></li>
                <li class="paginItem">
                    <c:if test="${pageList.pageNow>1}">
                        <a href="totalPageServlet?dangPage=${pageList.pageNow-1}">上一页</a>
                    </c:if>
                </li>
                <li class="paginItem">
                    <c:if test="${pageList.pageNow < pageList.pageSize}">
                        <a href="totalPageServlet?dangPage=${pageList.pageNow+1}">下一页</a>
                    </c:if>
                </li>
                <li class="paginItem"><a href="totalPageServlet?dangPage=${pageList.totalPage }"> <span class="pagenxt">末页 </span></a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>


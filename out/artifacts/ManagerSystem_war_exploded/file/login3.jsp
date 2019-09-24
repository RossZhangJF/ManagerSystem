<%--
  Created by IntelliJ IDEA.
  User: PC_01
  Date: 2019/9/19
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script src="../js/cloud.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(../images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <div class="loginbox loginbox2">

        <form action="loginServlet" method="post" id="fm">
            <ul>
                <li>
                    <p id="uNameMessage">${requestScope.message}</p>
                    <input id="uName" onfa name="username" type="text" value="201301003" class="loginuser" placeholder="输入学号或身份证号"/>
                </li>
                <li>
                    <p id="uPwdMessage"></p>
                    <input id="uPwd" name="password" type="password" value="123456" class="loginpwd" placeholder="输入密码"/>
                </li>
                <li class="yzm">
                    <p id="codeMessage"></p>
                    <span><input id="code" name="" type="text" value="验证码" /></span>
                    <cite>X3D5S</cite>
                </li>
                <li>
                    <input name="" type="submit" class="loginbtn" value="登录" onclick="clear()"/>
                    <label><input name="isPwd" type="checkbox" value="" checked="checked" />记住密码</label>
                    <label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>


    </div>

</div>


<div class="loginbm">版权所有  2014  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>

<script type="text/javascript">
    $(function(){
        //校验密码修改
        $("#fm").submit(function(){
            if($("#uName").val()==""){  //校验用户账号
                $("#uNameMessage").text("请输入账号");$("#uNameMessage").css("color","red");
                $("#uName").focus(function(){
                    $("#uNameMessage").remove();
                });
                return false;
            }else if($("#uPwd").val()==""){//校验密码
                $("#uPwdMessage").text("密码不能为空");$("#uPwdMessage").css("color","red");
                $("#uPwd").focus(function(){
                    $("#uPwdMessage").remove();
                });
                return false;
            }else {
                return true;
            }
            /*
            暂时不检查验证码
            if($("#code").val()== ""){ //请输入验证码
                $("#codeMessage").text("请输入验证码");$("#codeMessage").css("color","red");
                return false;
            }
            */
        })
    })

</script>
</body>

</html>


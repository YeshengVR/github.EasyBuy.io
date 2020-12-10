<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册详情</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/register.css">
    <style>
        body {
            overflow-x: hidden;
        }

        .regist2I {
            width: 300px;
        }

        .select {
            width: 300px;
            border: 0px;
            padding-left: 20px;
            color: rgb(161, 117, 161);
            height: 24px;
            font-size: 14px;
            line-height: 24px;
        }

        .regist2T {
            margin-left: 200px;
        }

        .select:focus {
            border: none;
            outline: none;
        }

        option {
            border: none;
            outline: none;
        }

        .tableItem .regist2tip {
            left: 320px;
            width: 300px;
            color: red;
        }

        .regist2I p {
            position: absolute;
            left: -70px;
            font-size: 16px;
        }

        .regist2I p sup {
            color: red;
            font-size: 20px;
            position: absolute;
            left: -10px;
            top: -10px;
        }

        #secTab .bigimg {
            position: absolute;
            top: 100px;
            right: 30px;
        }

        .main {
            position: relative;
        }

        .regist2btn {
            width: 300px;
        }

    </style>

</head>
<body>
<header id="headNav">
    <div class="innerNav cf">
        <a class="fl" href="#"><img src="images/logo.png" alt=""></a>
        <div class="headFont fr">
            <span>您好，欢迎光临易买网！<a href="loadpage.jsp">请登录</a></span>
            <a class="helpLink" href="#"><i class="runbun"></i>帮助中心<i class="turnb"></i></a>
        </div>
        <div class="outHelp">
            <ul class="helpYou" style="display: none;">
                <li><a href="#">包裹跟踪</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">在线退换货</a></li>
                <li><a href="#">在线投诉</a></li>
                <li><a href="#">配送范围</a></li>
            </ul>
        </div>
    </div>
</header>
<%--<%
    String phone = request.getParameter("phone");
%>--%>
<section id="secTab" class="main">
    <c:if test="${sessionScope.mobile!=null}">
    <form action="register2?action=submit&mobile=${sessionScope.mobile}" id="registerForm" method="post" onsubmit="return submt()">
        <div class="innerTab regist2T">
            <h2>易买网注册</h2>
            <div class="tableItem regist2I">
                <p><sup>*</sup>用&nbsp;户&nbsp;名</p><input type="text" id="loginname" name="loginname" required placeholder="用户昵称"/><span
                    class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>用户账户</p><input type="text" id="username" name="username" required placeholder="用户账户"/><span
                    class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>用户密码</p><input type="password" id="password" name="password" required placeholder="设置密码"
                                              /><span class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>确认密码</p><input type="password" id="rePassword" name="rePassword" required placeholder="确认密码"
                                             /><span class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</p>
                <select name="sex" id="sex" class="select">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</p><input type="text" id="meail" name="meail" placeholder="邮箱" <%--pattern="^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$--%>"/><span
                    class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup></sup>座&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</p><input type="text" id="phone" name="phone"  placeholder="座机号码" <%--pattern="\d{3}-\d{8}|\d{4}-\d{7}"--%>/><span
                    class="regist2tip"></span>
            </div>
            <div class="tableItem regist2I">
                <p><sup>*</sup>身&nbsp;份&nbsp;证</p><input type="text" id="identitycode" name="identitycode" required placeholder="身份证"
                                                         pattern="^\d{15}|\d{18}$"/><span class="regist2tip"></span>
            </div>
            <input type="submit" class="tableBtn regist2btn" value="注册">
        </div>
    </form>
    </c:if>
    <c:if test="${sessionScope.mobile==null}">

    </c:if>
    <img class="bigimg" src="images/l_img.png" alt="">
</section>
<footer id="footNav">
    <p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
    <p>Copyright © 易买网网上超市 2007-2016，All Rights Reserved</p>
</footer>
</body>
</html>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
    $(function(){
        $("#loginname").blur(loginname1);
        $("#meail").blur(meail1);
        $("#identitycode").blur(identitycode1);
        $("#username").blur(username1);
        $("#rePassword").blur(Repassword1);
    })
    function Repassword1() {
        var p1 = $("#password").val();
        var p2 = $("#rePassword").val();
        if(p1>20||p2>20){
            $("#rePassword").next().html("请设置小于20位的密码");
            $("#password").next().css("color", "red");
        }
        if(p1==p2){
            $("#rePassword").next().html("√");
            $("#Password").next().html("√");
            $("#rePassword").next().css("color", "green");
            return true;
        }else{
            $("#rePassword").next().html("两次密码不一致，请重新输入");
            $("#password").next().css("color", "red");
            return false;
        }
    }
    function submt() {
        return loginname1() && username1() && meail1()&&identitycode1()&&Repassword1();
    }

    function loginname1() {
        var loginname = $("#loginname").val();
        if (loginname.length > 20) {
            $("#loginname").next().html("用户名长度不能超过20位");
            $("#loginname").next().css("color", "red");
            return false;
        } else {
            $("#loginname").next().html("√");
            $("#loginname").next().css("color", "green");
            return true;
        }
    }
    if(loginname=""){
        $("#loginname").next().html("用户民不能为空");
        $("#loginname").next().css("color", "red");
    }
    function username1() {
        var username = $("#username").val();
        var regex = /^.{8,20}$/;
        var flag;
        if (!regex.test(username)) {
            $("#username").next().html("账户长度最小8位，不能超过20位");
            $("#username").next().css("color", "red");
            return false;
        } else {
            // $("#username").next().html("√");
            $.ajax({
                async: false,
                type: "post",
                url: "register2",
                data: {action: "dousername", username: username},
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    flag = result;
                }
            })
        }

        if (!flag) {
            $("#username").next().html("账户名不可用，已被使用");
            $("#username").next().css("color", "red");
        } else {
            $("#username").next().html("√");
            $("#username").next().css("color", "green");
        }
        return flag;
    }

    function meail1() {
        var meail = $("#meail").val();
        var regex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        var flag;
        if (!regex.test(meail)) {
            $("#meail").next().html("请填写正确邮箱");
            $("#meail").next().css("color", "red");
            return false;
        } else {
            // $("#meail").next().html("√");
            $.ajax({
                async: false,
                type: "post",
                url: "register2",
                data: {action: "doemail", meail: meail},
                dataType: "json",
                success: function (result) {
                    // console.log(result);
                    flag = result;
                }
            })
        }

        if (!flag) {
            $("#meail").next().html("该邮箱不可用，邮箱已被使用");
            $("#meail").next().css("color", "red");
        } else {
            $("#meail").next().html("√");
            $("#meail").next().css("color", "green");
        }
        return flag;
    }

    function identitycode1() {
        var identitycode = $("#identitycode").val();
        var regex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        var flag;
        if (regex.test(identitycode)==false) {
            $("#identitycode").next().html("请输入正确身份证号");
            $("#identitycode").next().css("color", "red");
            return false;
        } else {
            // $("#identitycode").next().html("");
            $.ajax({
                async: false,
                type: "post",
                url: "register2",
                data: {action: "doIdent", identitycode: identitycode},
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    flag = result;
                }
            })
        }
        if (!flag) {
            $("#identitycode").next().html("该身份证号已被使用！");
            $("#identitycode").next().css("color", "red");
            return flag;
        } else {
            $("#identitycode").next().html("√");
            $("#identitycode").next().css("color", "green");
            return flag;
        }
    }
</script>
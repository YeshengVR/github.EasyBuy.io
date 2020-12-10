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
    <title>注册</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <style>
        #validateCodeImg{
            width: 135px;
        }
        #tipphone{
            position: absolute;
            left: 340px;
            display: block;
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
<section id="secTab">
    <form action="register1?action=register2" id="registerForm" onsubmit="return subm()" method="post">
        <div class="innerTab">
            <h2>易买网注册</h2>
            <div class="tableItem">
                <input type="text" name="phone" id="phone" required placeholder="手机号码" pattern="^1[23456789]\d{9}$"/><span id="tipphone"></span>
            </div>
            <div class="cf">
                <div class="tableItem onlyItem fl">
                    <input class="validateCode" type="text" name="validateCode" placeholder="验证码"/>
                </div>
                <a href='javascript:changeImg()' onclick="changeImg()">
                    <img alt="验证码看不清，换一张" src="YanzhengServlet" id="validateCodeImg" onclick="changeImg()">
                    <span id="seeagain">看不清，换一张</span></a>
<%--                <a class="tableText fr" href="#">获取验证码</a>--%>
            </div>
            <p class="clickRegist">点击注册，表示您同意易买网 <a href="#">《服务协议》</a></p>
            <input type="submit" class="tableBtn" value="同意协议并进行注册">
        </div>
    </form>
</section>
<footer id="footNav">
    <p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
    <p>Copyright © 易买网网上超市 2007-2016，All Rights Reserved</p>
</footer>
</body>
</html>
<script type="text/javascript">
    $(function(){
        changeImg();
    })
    //刷新验证码
    function changeImg() {
        var number = Math.ceil(Math.random()*4);
        var str;
        if(number==1){
            str='l';
        }else if(number==2){
            str='n'
        }else{
            str='nl'
        }
        document.getElementById("validateCodeImg").src = "YanzhengServlet?createTypeFlag="+str;
    }
    function subm(){
        return Mobile()&&yanzhengma();
    }
    function Mobile(){
        var flag;
        var phone = $("#phone").val();
        $.ajax({
            async:false,
            type:"post",
            url:"register1?action=regist1",
            data:{phone:phone},
            dataType:"json",
            success:function (result) {
                flag = result==true?true:false;
            }
        })
        if(!flag){
            $("#tipphone").html("该手机号不可用，手机号已被注册");
            $("#tipphone").css("color","red");
        }else{
            $("#tipphone").html("");
        }
        return flag;
    }
    function yanzhengma(){
        var flag;
        var number = Math.ceil(Math.random()*4);
        var validateCode = $(".validateCode").val();
        var str;
        if(number==1){
            str='l';
        }else if(number==2){
            str='n'
        }else{
            str='nl'
        }
        $.ajax({
            async:false,
            type:"post",
            url:"authcode",
            data:{createTypeFlag:str,validateCode:validateCode},
            dataType:"json",
            success:function (result) {
                console.log(result);
                flag = result=="true"?true:false;
            }
        })
        if(!flag){
            $("#seeagain").html("验证码错误，请重新输入");
            $("#seeagain").css("color","red");
        }else{
            $("#seeagain").html("");
        }
        return flag;
    }
</script>
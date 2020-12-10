<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/load.css">
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	<META HTTP-EQUIV="Expires" CONTENT="0">
	<style>
		#tip{
			position: absolute;
			width: 100%;
			text-align: center;
			height: 100px;
			line-height: 100px;
			font-size: 24px;

		}
		#tiptd{
			margin: 50px auto;
			width: 200px;
			padding: 10px;
			line-height: 60px;
			background-color: skyblue;
			/*display: block;*/
			border-radius: 20px;
			display: none;
		}
		body{
			overflow-x: hidden;
		}
	</style>
</head>
<body>
<span id="tip"><span id="tiptd">登陆失败</span></span>
	<header id="headNav">
		<div class="innerNav cf">
			<a class="fl" href="#"><img src="images/logo.png" alt=""/></a>
			<div class="headFont fr">
				<span>您好，欢迎光临易买网！<a href="registerpage.jsp">请注册</a></span>
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
	<section id="secBody">
		<c:if test="${cookie.username.value!=null}">
		<form action="login.do?action=login" id="loadForm" method="post">
			<div class="innerBody cf">
				<img class="fl" src="images/l_img.png" alt=""/>
				<div class="tableWrap fr">
					<div class="tableTap cf">
						<h3 class="fl">易买网用户登录</h3>
						<a class="fr" href="registerpage.jsp">注册账号</a>
					</div>
					<div class="tableItem">
						<i class="userHead"></i>
						<!--邮箱、以13、15、18开头的电话或者是2~4个汉字-->
						<input type="text" name="username" id="username" placeholder="邮箱/手机/用户名" required value="${cookie.username.value}"/>
							   <!--pattern="[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}|^1[3578]\d{9}$|^[\u4e00-\u9fa5]{2,4}$"-->
					</div>
					<div class="tableItem">
						<i class="userLock"></i>
						<input type="password" name="password" id="password" placeholder="密码" required value="${cookie.password.value==null?null:cookie.password.value}" pattern="^\w{6,10}$"/>
					</div>
					<div class="tableAuto cf">
						<label for="ifAuto"><a class="autoMatic fl" href="#"><input class="loadGiet" value="1" id="ifAuto" type="checkbox" name="ifAuto" checked/>自动登录</a></label>
						<a class="fr" href="#">忘记密码？</a>
					</div>
					<!--<button class="tableBtn">登录</button>-->
					<input type="submit" class="tableBtn" value="登录"/>
					<h2 class="moreWeb">更多合作网站账号登录</h2>
					<div class="outType cf">
						<ul class="loadType cf">
							<li class="fl"><a href="https://www.qq.com/"></a></li>
							<li class="fl"><a href="https://weibo.com/login.php/"></a></li>
							<li class="fl"><a href="https://www.alipay.com/"></a></li>
							<li class="fl"><a href="https://weixin.qq.com/"></a></li>
							<li class="loadMore fr"><a href="https://www.baidu.com/">更多合作网站</a><i></i></li>
						</ul>
					</div>
					<ul class="typeWeb cf">
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
					</ul>
				</div>
			</div>
		</form>
		</c:if>
		<c:if test="${cookie.username.value==null}">
		<form action="login.do?action=login" id="loadForm" method="post">
			<div class="innerBody cf">
				<img class="fl" src="images/l_img.png" alt=""/>
				<div class="tableWrap fr">
					<div class="tableTap cf">
						<h3 class="fl">易买网用户登录</h3>
						<a class="fr" href="registerpage.jsp">注册账号</a>
					</div>
					<div class="tableItem">
						<i class="userHead"></i>
						<!--邮箱、以13、15、18开头的电话或者是2~4个汉字-->
						<input type="text" name="username" id="username" placeholder="邮箱/手机/用户名" required value=""/>
						<!--pattern="[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}|^1[3578]\d{9}$|^[\u4e00-\u9fa5]{2,4}$"-->
					</div>
					<div class="tableItem">
						<i class="userLock"></i>
						<input type="password" name="password" id="password" placeholder="密码" required value="" pattern="^\w{6,10}$"/>
					</div>
					<div class="tableAuto cf">
						<label for="ifAuto"><a class="autoMatic fl" href="#"><input class="loadGiet" value="1" id="ifAuto" type="checkbox" name="ifAuto"/>自动登录</a></label>
<%--						<a class="fr" href="#">忘记密码？</a>--%>
					</div>
					<!--<button class="tableBtn">登录</button>-->
					<input type="submit" class="tableBtn" value="登录"/>
					<h2 class="moreWeb">更多合作网站账号登录</h2>
					<div class="outType cf">
						<ul class="loadType cf">
							<li class="fl"><a href="https://www.qq.com/"></a></li>
							<li class="fl"><a href="https://weibo.com/login.php/"></a></li>
							<li class="fl"><a href="https://www.alipay.com/"></a></li>
							<li class="fl"><a href="https://weixin.qq.com/"></a></li>
							<li class="loadMore fr"><a href="https://www.baidu.com/">更多合作网站</a><i></i></li>
						</ul>
					</div>
					<ul class="typeWeb cf">
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
						<li class="fl"><i></i><a href="https://www.baidu.com/">百度</a></li>
					</ul>
				</div>
			</div>
		</form>
		</c:if>
	</section>
	<footer id="footNav">
		<p><a href="#">沪ICP备13044278号</a>|&nbsp;&nbsp;合字B1.B2-20130004&nbsp;&nbsp;|<a href="#">营业执照</a></p>
		<p>Copyright © 1号店网上超市 2007-2016，All Rights Reserved</p>
	</footer>
<%session.removeAttribute("user");%>
</body>
</html>
<script>
    function loginauto(){
        var inin=1;
        $(".tableAuto label").click(function(){
            if(inin<2){
                inin=1;
            }
            if(inin==1) {
                $(this).find("#ifAuto").attr("checked", "checked");
            }else{
                $(this).find("#ifAuto").removeAttr("checked");
            }
            i++;
        })
    }
	function logintip(){
		if(${sessionScope.flag==null?false:true}){
			$("#tiptd").fadeIn("slow").delay(1000).fadeOut("slow");
		}
	}
	$(function(){
		logintip();
        loginauto();
	})
</script>


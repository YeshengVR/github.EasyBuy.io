<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2020/10/30
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>地址信息</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/select.js"></script>

    <script type="text/javascript" src="js/lrscroll.js"></script>

    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">
    <script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <style>
        .nuw {
            width: 211px;
            text-decoration: none;
            height: 40px;
            line-height: 40px;
            background-color: #FFF;
            color: #ff4e00;
            z-index: 800;
        }

        .acd {
            display: block;
            position: absolute;
            top: 0px;
        }

        .zj {
            display: block;
        }

        .leftNav {
            display: none;
        }

        .zj_l_c a {
            color: brown;
        }

        .fl1 a {
            color: aliceblue;
        }

        .formadd {
            height: 400px;
            width: 500px;
            margin: 20px auto;
            position: relative;
        }

        .formadd input {
            padding-left: 20px;
            padding-top: 2px;
            border-radius: 10px;
            border: 1px solid black;
            line-height: 35px;
            height: 35px;
            outline: none;
            margin: 5px;
            font-size: 16px;
        }

        em {
            font-size: 16px;
            font-style: normal;
            width: 100px;
            margin-right: 10px;
            display: block;
            float: left;
            text-align: right;
            top: 8px;
            position: relative;
        }

        .formadd input[type=submit] {
            padding: 0px;
            width: 150px;
            left: 18px;
            position: relative;
            border: none;
            cursor: pointer;
            background-color:rgb(255, 50, 0);
        }

        .spp {
            color: red;
            position: absolute;
            left: 105px;
            top: 4px;
        }

        #dizhi {
            font-size: 27px;
            position: absolute;
            top: 250px;
            left: 50px;
            font-family: fangsong;
        }
    </style>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <!--Begin 所在收货地区 Begin-->
        <span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>

                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0"
                               cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <script>
            function city() {
                $(".s_city_c table span").click(function () {
                    var val = $(this).html();
                    $(".s_city_c table span").removeClass("c_check");
                    $(this).addClass("c_check");
                    $(".s_city>span").html(val);
                })
            }

            city();
        </script>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<span class="fl">你好，${sessionScope.user==null?"<a href='loadpage.jsp'>登录</a>":sessionScope.user.loginname}&nbsp;&nbsp;&nbsp;${sessionScope.user==null?"<a href='registerpage.jsp'>免费注册</a>":"<a href='login.do?action=layout'>退出登录</a>"}|&nbsp;<a
                    href="Order.jsp">我的订单</a>&nbsp;|</span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="Favority.jsp">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="Favority.jsp">我的收藏夹</a></li>
                                <li><a href="Favority.jsp">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="CategoryList.jsp">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="CategoryList.jsp">客户服务</a></li>
                                <li><a href="CategoryList.jsp">客户服务</a></li>
                                <li><a href="CategoryList.jsp">客户服务</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="CategoryList.jsp">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="CategoryList.jsp">网站导航</a></li>
                                <li><a href="CategoryList.jsp">网站导航</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="index.jsp"><img src="images/logo.png"/></a></div>
    <div class="search">
        <form action="catelist?action=search" method="post" id="search">
            <input type="text" value="" class="s_ipt"/>
            <input type="submit" value="搜索" class="s_btn"/>
        </form>
        <span class="fl">
            <a href="indexServlet?action=ty&cname=香奈儿（Chanel）&carid=27">香奈儿（Chanel）</a>
            <a href="indexServlet?action=ty&cname=迪奥（Dior）&carid=28">迪奥（Dior）</a>
            <a href="indexServlet?action=ty&cname=范思哲（VERSACE）&carid=29">范思哲（VERSACE）</a>
            <a href="indexServlet?action=ty&cname=菲拉格慕（Ferragamo）&carid=30">菲拉格慕（Ferragamo）</a>
            <a href="indexServlet?action=ty&cname=兰蔻（LANCOME）&carid=31">兰蔻（LANCOME）</a>
            <a href="indexServlet?action=ty&cname=爱马仕（HERMES）&carid=32">爱马仕（HERMES）</a>
        </span>
    </div>
    <div class="i_car" id="i_car">
        <div class="car_t" id="car_t">购物车</div>
        <div class="car_bg">
            <c:if test="${sessionScope.user==null}">
                <!--Begin 购物车未登录 Begin-->
                <div class="un_login">还未登录！<a href="loadpage.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
                <!--End 购物车未登录 End-->
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <!--Begin 购物车已登录 Begin-->
                <ul class="cars">

                </ul>
                <a href="javascript:shoppagesth('back')">上一页</a><a href="javascript:shoppagesth('next')">下一页</a>
                <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span id="sum"></span></div>
                <div class="price_a"><a href="BuyCar.jsp">去购物车结算</a></div>
                <!--End 购物车已登录 End-->
            </c:if>
        </div>
    </div>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">全部商品分类</div>
            <div class="leftNav">
                <ul id="productMenu">
                </ul>
            </div>
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="CategoryList.jsp">美食</a></li>
            <li><a href="CategoryList.jsp">生鲜</a></li>
            <li><a href="CategoryList.jsp">家居</a></li>
            <li><a href="CategoryList.jsp">女装</a></li>
            <li><a href="CategoryList.jsp">美妆</a></li>
            <li><a href="CategoryList.jsp">数码</a></li>
            <li><a href="CategoryList.jsp">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<div class="i_bg">
    <c:if test="${sessionScope.user!=null}">
    <c:if test="${pageContext.request.getParameter('address')==null}">
    <div id="dizhi">添加地址信息页面</div>
    </c:if>
    <c:if test="${pageContext.request.getParameter('address')!=null}">
    <div id="dizhi">修改地址信息页面</div>
    </c:if>
    <div class="tad">
            <%--        修改地址信息--%>
        <c:if test="${pageContext.request.getParameter('address')==null}">
            <form class="formadd" action="Buy2.az?action=modifyAddress" method="post" onsubmit="return su()">
                <em class="p_td" width="160"><span class="spp">*</span>收件人名称</em>
                <input type="hidden" name="userid" value="${sessionScope.user.id}"><span></span>
                <input type="text" name="name"
                       width="395"
                       value="${sessionScope.address.NICKNAME==null?sessionScope.user.loginname:sessionScope.address.NICKNAME}"></input><span></span><br/>
                <em class="p_td" width="160">电子邮件</em>
                <input type="text" name="email"
                       width="395"
                       value="${sessionScope.address.EMAIL==null?sessionScope.user.email:sessionScope.address.EMAIL}"></input><span></span><br/>
                <em class="p_td"><span class="spp">*</span>详细地址信息</em>
                <input type="text" name="address" value="${sessionScope.address.ADDRESS}"></input><span></span><br/>
                <em class="p_td">邮政编码</em>
                <input type="text" name="youzheng" value="${sessionScope.address.YOUBIAN}"></input><span></span><br/>
                <em class="p_td">座机</em>
                <input type="text" name="telphone" value="${sessionScope.user.phone}"></input><span></span><br/>
                <em class="p_td"><span class="spp">*</span>手机</em>
                <input type="text" name="moblie" value="${sessionScope.address.PHONE}"></input><span></span><br/>
                <em class="p_td">备注</em>
                <input type="text" name="remark" value="${sessionScope.address.REMARK}"></input><span></span><br/>
                <label for="default"><em class="p_td">默认</em></label><input type="checkbox" name="default" value="0"
                                                                            id="default">
                <input type="submit" value="确认"><br/>
            </form>
        </c:if>
            <%--        添加地址信息--%>
        <c:if test="${pageContext.request.getParameter('address')!=null}">
            <form class="formadd" action="Buy2.az?action=addAddress" method="post" onsubmit="return su()">
                <em class="p_td" width="160"><span class="spp">*</span>收件人名称</em>
                <input type="hidden" name="userid" value="${sessionScope.user.id}"><span></span>
                <input type="text" name="name"
                       width="395"
                       value="${sessionScope.address.NICKNAME==null?sessionScope.user.loginname:sessionScope.address.NICKNAME}"></input><span></span><br/>
                <em class="p_td" width="160">电子邮件</em>
                <input type="text" name="email"
                       width="395"
                       value="${sessionScope.address.EMAIL==null?sessionScope.user.email:sessionScope.address.EMAIL}"></input><span></span><br/>
                <em class="p_td"><span class="spp">*</span>详细地址信息</em>
                <input type="text" name="address" value="${sessionScope.address.ADDRESS}"></input><span></span><br/>
                <em class="p_td">邮政编码</em>
                <input type="text" name="youzheng" value="${sessionScope.address.YOUBIAN}"></input><span></span><br/>
                <em class="p_td">座机</em>
                <input type="text" name="telphone" value="${sessionScope.user.phone}"></input><span></span><br/>
                <em class="p_td"><span class="spp">*</span>手机</em>
                <input type="text" name="moblie" value="${sessionScope.address.PHONE}"></input><span></span><br/>
                <em class="p_td">备注</em>
                <input type="text" name="remark" value="${sessionScope.address.REMARK}"></input><span></span><br/>
                <label for="default1"> <em class="p_td">默认</em></label><input type="checkbox" name="default" value="0"
                                                                              id="default1">
                <input type="submit" value="确认"><br/>
            </form>
        </c:if>
        </c:if>
        <%--    <% session.removeAttribute("address");%>--%>


    </div>
    <!--Begin Footer Begin -->
    <div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b1.png" width="62" height="62"/></td>
                    <td><h2>正品保障</h2>正品行货 放心购买</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b2.png" width="62" height="62"/></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b3.png" width="62" height="62"/></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b4.png" width="62" height="62"/></td>
                    <td><h2>准时送达</h2>收货时间由你做主</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
            <a href="#" class="b_sh1">新浪微博</a>
            <a href="#" class="b_sh2">腾讯微博</a>
            <p>
                服务热线：<br/>
                <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118"/></div>
            <img src="images/ss.png"/>
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 ,
            Technical Support: Dgg Group <br/>
            <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98" height="33"/><img
                src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98" height="33"/><img
                src="images/b_5.gif" width="98" height="33"/><img src="images/b_6.gif" width="98" height="33"/>
        </div>
    </div>
    <!--End Footer End -->
</body>
</html>
<script>
    function su() {
        return ifnickname() && ifyouzheng() && ifemail() && ifaddress() && ifremark() && ifmoblie();
    }

    $(function () {
        $("input[name='address']").blur(ifaddress);
        $("input[name='name']").blur(ifnickname);
        $("input[name='remark']").blur(ifremark);
        $("input[name='email']").blur(ifemail);
        $("input[name='youzheng']").blur(ifyouzheng);
        $("input[name='moblie']").blur(ifmoblie);
    })

    function ifmoblie() {
        var regex = /^1[23456789]\d{9}$/;
        var val = $("input[name='moblie']").val();
        if (val.length == 0) {
            $("input[name='moblie']").next().html("请输入符合规范的手机号");
            $("input[name='moblie']").next().css("color", "red");
            return false;
        }
        if (!regex.test(val)) {
            $("input[name='moblie']").next().html("请输入符合规范的手机号");
            $("input[name='moblie']").next().css("color", "red");
            return false;
        } else {
            $("input[name='moblie']").next().html("√");
            $("input[name='moblie']").next().css("color", "green");
            return true;
        }
        return false;
    }

    function ifnickname() {
        var val = $("input[name='name']").val();
        if (val.length > 20) {
            $("input[name='name']").next().html("名字只能取20个字符以内");
            $("input[name='name']").next().css("color", "red");
            return false;
        } else {
            $("input[name='name']").next().html("√");
            $("input[name='name']").next().css("color", "green");
            return true;
        }
        return false;
    }

    function ifremark() {
        var val = $("input[name='remark']").val();
        if (val.length > 50) {
            $("input[name='remark']").next().html("不能超过50个字符");
            $("input[name='remark']").next().css("color", "red");
            return false;
        } else {
            $("input[name='remark']").next().html("√");
            $("input[name='remark']").next().css("color", "green");
            return true;
        }
        return false;
    }

    function ifyouzheng() {
        var regex = /^[0-9]*$/;
        var val = $("input[name='youzheng']").val();
        if (val == "" || val == null) {
            $("input[name='youzheng']").next().html("√");
            $("input[name='youzheng']").next().css("color", "green");
            return true;
        }
        if (!regex.test(val)) {
            $("input[name='youzheng']").next().html("请输入符合规范的邮箱");
            $("input[name='youzheng']").next().css("color", "red");
            return false;
        } else {
            $("input[name='youzheng']").next().html("√");
            $("input[name='youzheng']").next().css("color", "green");
            return true;
        }
        return false;
    }

    function ifemail() {
        var regex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        var val = $("input[name='email']").val();
        if (val == "" || val == null) {
            $("input[name='email']").next().html("√");
            $("input[name='email']").next().css("color", "green");
            return true;
        }
        if (!regex.test(val)) {
            $("input[name='email']").next().html("请输入符合规范的邮箱");
            $("input[name='email']").next().css("color", "red");
            return false;
        } else {
            $("input[name='email']").next().html("√");
            $("input[name='email']").next().css("color", "green");
            return true;
        }
        return false;
    }

    function ifaddress() {
        var val = $("input[name='address']").val();
        if (val.length > 50) {
            $("input[name='address']").next().html("不能超过50个字符");
            $("input[name='address']").next().css("color", "red");
            return false;
        } else {
            $("input[name='address']").next().html("√");
            $("input[name='address']").next().css("color", "green");
            return true;
        }
        return false;
    }
</script>
<script>
    function showtic() {
        $(".nav").hover(function () {
            $(".leftNav").show();
        }, function () {
            $(".leftNav").hide();
        })
    }

    function city() {
        $(".s_city_c table span").click(function () {
            var val = $(this).html();
            $(".s_city_c table span").removeClass("c_check");
            $(this).addClass("c_check");
            $(".s_city>span").html(val);
        })
    }

    city();

    function sumss() {
        var sums = 0;
        $.ajax({
            async: false,
            type: "post",
            url: "indexServlet",
            data: {action: "sums"},
            dataType: "json",
            success: function (result) {
                sums = result;
            }
        })
        return sums;
    }

    var currentpageshop = 1;
    var totalPageshop = 0;
    var producthtmls = "";
    $(function () {
        productmenu();
        $("#productMenu li").hover(function () {
            $(this).find(".fj").addClass("nuw");
            // $(this).find(".zj").css("top","0px");
            $(this).find(".zj").show();
        }, function () {
            $(this).find(".fj").removeClass("nuw");
            // $(this).find(".zj").removeClass("acd");
            $(this).find(".zj").hide();
        })
        shoppingrecord();
        showtic();
    })

    function productmenu() {
        var i = 0;
        $.ajax({
            async: false,
            type: "post",
            url: "indexServlet",
            data: {action: "categorylv1"},
            dataType: "json",
            success: function (result) {
                for (var category1 of result) {
                    producthtmls += "<li>\n" +
                        "                    <div class='fj'>\n" +
                        "                        <span class='n_img'><span></span><img src='" + category1.ICONCLASS + "' /></span>\n" +
                        "                            <span class='fl fl1'><a href='indexServlet?action=doty3&cname=" + category1.NAME + "&carid=" + category1.ID + "'>" + category1.NAME + "</a></span>\n" +
                        "                        </div>\n" +
                        "                        <div class='zj' style='top:" + (i * (-40)) + "px;'>\n" +
                        "                            <div class='zj_l'>\n";
                    productmenu2(category1.ID);
                    producthtmls += "</div>\n" +
                        "                            <div class='zj_r'>\n" +
                        "                                <a href='#'><img src='images/n_img1.jpg' width='236' height='200' /></a>\n" +
                        "                                <a href='#'><img src='images/n_img2.jpg' width='236' height='200' /></a>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </li>";
                    i++;
                }
            }
        })
        $("#productMenu").html(producthtmls);

        $("#productMenu li").mouseover(function () {
            $(this).find(".fj a").css("color", "rgb(255, 78, 0)");
        })
        $("#productMenu li").mouseleave(function () {
            $(this).find(".fj a").css("color", "aliceblue");
        })
    }

    function productmenu2(category1) {
        $.ajax({
            async: false,
            type: "post",
            url: "indexServlet",
            data: {action: "categorylv2", category: category1},
            dataType: "json",
            success: function (result) {
                for (var category2 of result) {
                    producthtmls += "<div class='zj_l_c'>" + "<h2><a href='indexServlet?action=doty2&cname=" + category2.NAME + "&carid=" + category2.ID + "' style='color: #333333'>" + category2.NAME + "</a></h2>";
                    productmenu3(category2.ID);
                    producthtmls += "</div>";
                }
            }
        })
        // console.log(category1);
    }

    function productmenu3(category2) {
        $.ajax({
            async: false,
            type: "post",
            url: "indexServlet",
            data: {action: "categorylv3", category: category2},
            dataType: "json",
            success: function (result) {
                for (var category3 of result) {
                    producthtmls += "<a href='indexServlet?action=ty&cname=" + category3.NAME + "&carid=" + category3.ID + "'>" + category3.NAME + "</a>|";
                }
            }
        })
    }

    function shoppingrecord() {
        var shoprecordhtml = "";
        <%--console.log(${sessionScope.user.id});--%>
        var sum = 0;
        $.ajax({
            async: false,
            type: "post",
            url: "ShoppingServlet.zz",
            data: {
                action: "shoprecord",
                user:${sessionScope.user.id==null?"null":sessionScope.user.id},
                currentpage: currentpageshop
            },
            dataType: "json",
            success: function (result) {
                totalPageshop = result.totalPage;
                for (var shopRecord of result.list) {
                    shoprecordhtml += "<li>" +
                        "<div class='img'><a href=\"catelist?action=pagetiao&idd=" + shopRecord.PRODUCTID + "\"><img src='" + shopRecord.FILENAME + "' width='58' height='58' /></a></div>" +
                        "<div class='name'><a href=\"catelist?action=pagetiao&idd=" + shopRecord.PRODUCTID + "\">" + findname(shopRecord.PRODUCTID) + "</a></div>" +
                        "<div class='price'><font color='#ff4e00'>￥" + shopRecord.PRICE + "</font> X" + shopRecord.AMOUNT + "</div>" +
                        "</li>";
                }
            }
        })
        sum = sumss();
        $("#sum").html(sum);
        $(".cars").html(shoprecordhtml);
    }

    function findname(id) {
        var shoprecordhtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "ShoppingServlet.zz",
            data: {action: "selectname", id: id},
            dataType: "json",
            success: function (result) {
                shoprecordhtml = result;
            }
        })
        return shoprecordhtml;
    }

    function shoppagesth(shoppage) {
        if ("next" == shoppage) {
            if (currentpageshop == totalPageshop) {
                currentpageshop = totalPageshop
            } else {
                currentpageshop += 1;
            }
            shoppingrecord();
        } else if ("back" == shoppage) {
            if (currentpageshop == 1) {
                currentpageshop = 1;
            } else {
                currentpageshop -= 1;
            }
            shoppingrecord();
        }
    }
</script>
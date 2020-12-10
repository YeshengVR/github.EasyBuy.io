<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript" src="js/n_nav.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

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
    <script type="text/javascript" src="js/lrscroll_1.js"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
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

        .pages {
            height: 40px;
            width: 650px;
            margin: 0px auto;
        }

        .left {
            float: left;
        }

        .red {
            color: red;
        }

        .pages input {
            height: 36px;
            line-height: 36px;
            overflow: hidden;
            color: #666666;
            font-size: 16px;
            text-align: center;
            display: inline-block;
            padding: 0 12px;
            margin: 0 4px;
            border: 1px solid #cccccc;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border-radius: 2px;
        }

        .dds {
            position: absolute;
            margin: 0px auto;
        }

        .pagespap {
            float: left;
        }

        .ss {
            cursor: pointer;
        }

        .shoxin {
            width: 68px;
            height: 28px;
            line-height: 28px;
            overflow: hidden;
            text-indent: 33px;
            float: left;
            display: inline;
            margin-right: -1px;
            border: 1px solid #cccccc;
            color: #888888;
            background: url(images/heart_h.png) no-repeat 10px center;
        }

        .hidexin {
            color: #ff4e00;
            background: url(images/heart.png) no-repeat 10px center;
            width: 68px;
            height: 28px;
            line-height: 28px;
            overflow: hidden;
            text-indent: 33px;
            float: left;
            display: inline;
            margin-right: -1px;
            border: 1px solid #cccccc;
        }

        /*ul.cate_list li>.carbg>a>.ss:hover{
            color:#888888;background:url(images/heart_h.png) no-repeat 10px center;
        }
        ul.cate_list li>.carbg>a>.j_car:hover{
            color:#FFF; background:url(images/cars_h.png) no-repeat 24px center; background-color:#ff4e00; border:1px solid #ff4e00;
        }*/
    </style>
    <title>商品页</title>
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
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
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
            <input type="text" value="${sessionScope.search}" id="searchs" name="search" class="s_ipt"/>
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
            <li><a href="#">美食</a></li>
            <li><a href="#">生鲜</a></li>
            <li><a href="#">家居</a></li>
            <li><a href="#">女装</a></li>
            <li><a href="#">美妆</a></li>
            <li><a href="#">数码</a></li>
            <li><a href="#">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div class="postion">
        <span class="fl"><a href="javascript:funcx()">全部</a> >  </span>
        <span class="n_ch">
            <span class="fl">查询内容：<font>${sessionScope.search!=null?sessionScope.search:(sessionScope.cname==null?"":sessionScope.cname)}</font></span>
            <a href="javascript:funcx()"><img src="images/s_close.gif"/></a>
        </span>
    </div>
    <!--Begin 筛选条件 Begin-->
    <div class="content mar_10">
        <table border="0" class="choice" style="width:100%; font-family:'宋体'; margin:0 auto;" cellspacing="0"
               cellpadding="0">
        </table>
    </div>
    <!--End 筛选条件 End-->
    <div class="content mar_20">
        <div class="l_history">
            <div class="his_t">
                <span class="fl">浏览历史</span>
                <span class="fr"><a href="javascript:deleteallhist()">清空</a></span>
            </div>
            <ul id="hist">
            </ul>
        </div>
        <div class="l_list">
            <div class="list_t">
            	<span class="fl list_or">
                	<a href="javascript:cateajax()" class="now" id="moren" value="0">默认</a>
                    <a href="javascript:Sales()" id="xiaoliang" value="1">
                    	<span class="fl">销量</span>                        
                        <span class="i_up">销量从低到高显示</span>
                        <span class="i_down">销量从高到低显示</span>                                                     
                    </a>
                    <a href="javascript:xiaoliang()" id="jiage" value="2">
                    	<span class="fl">价格</span>                        
                        <span class="i_up">价格从低到高显示</span>
                        <span class="i_down">价格从高到低显示</span>     
                    </a>
                    <a href="javascript:createtime()" value="3">新品</a>
                </span>
                <span class="fr faxian">共发现${sessionScope.catelist.totalMessage}件</span>
            </div>
            <div class="list_c">
                <ul class="cate_list" id="catelist">
                    <c:forEach items="${sessionScope.catelist.list}" var="product">
                        <li>
                            <div class="img"><a href="catelist?action=pagetiao&idd=${product.ID}"><img
                                    src="${product.FILENAME}" width="210" height="185"/></a>
                            </div>
                            <div class="price">
                                <font>￥<span>${product.price}</span></font> &nbsp; <fmt:formatNumber
                                    value="${product.price*0.6}"></fmt:formatNumber> R
                            </div>
                            <div class="name"><a href="#">${product.DESCRIPTION}</a></div>
                            <div class="carbg">
                                <a href="#" class='ss'>收藏</a>
                                <a href="catelist?action=pagetiao&idd=${product.ID}" class="j_car">加入购物车</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="pages">
                    <p class="pagespap left"><span
                            class="red left">${sessionScope.catelist.currentPage==0?1:sessionScope.catelist.currentPage}</span><font
                            class="left">/${sessionScope.catelist.totalPage==0?1:sessionScope.catelist.totalPage}</font>
                    </p>
                    <a href="javascript:pagecatelist('back')" class="p_pre left">上一页</a>
                    <a href="javascript:pagecatelist('first')" class="left">首页</a>
                    <form action="javascript:pagem()" method="post" class="left">
                        <input type="text" pattern="^[0-9]*$" name="pagepp" id="pagepp" placeholder="请输入跳转到几页">
                        <div class='dds' style='display:none'>请输入符合规范的数据</div>
                        <input type="submit" value="确定">
                    </form>
                    <a href="javascript:pagecatelist('last')" class="left">尾页</a>
                    <a href="javascript:pagecatelist('next')" class="p_pre left">下一页</a>
                </div>
            </div>
        </div>
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

</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
<%--历史浏览记录脚本--%>
<script>
    /**
     * 如果没有商品集合则执行展示全部的功能
     */
    <c:if test="${sessionScope.catelist.list==null}">
    $(function () {
        cateajax();
        $(".carbg a:first").click(shoudianji(this));
    })
    </c:if>
    var currentpagecate = 1;
    var totalPagecate = ${sessionScope.catelist.totalPage==null?1:sessionScope.catelist.totalPage};
    var search = $("#searchs").val();
    var cname = $(".i_bg .postion .n_ch .fl font").text();

    function clickadd() {
        $(".content .l_list .list_or a").click(function () {
            $(this).addClass("now");

            $(this).siblings().removeClass("now");
        })
    }

    $(function () {
        history();
        clickadd();
        shoucang();
    })

    /**
     * 历史记录
     */
    function history() {
        var historyhtml = "";
        var userid = "";
        <c:if test="${sessionScope.user.id!=null}">
        userid = ${sessionScope.user.id};
        </c:if>
        $.ajax({
            async: false,
            type: "post",
            url: "history.z",
            data: {action: "gethistory", userid: userid},
            dataType: "json",
            success: function (result) {
                if (result != null) {
                    for (var history of result) {
                        historyhtml += "<li class='histhist'>\n" +
                            "                    <div class=\"img\"><a href=\"catelist?action=pagetiao&idd=" + history.PRODUCTID + "\"><img src='" + history.FILENAME + "' width=\"185\" height=\"162\" /></a></div>\n" +
                            "                \t<div class=\"name\"><a href=\"catelist?action=pagetiao&idd=" + history.PRODUCTID + "\">" + history.DESPCRIPTION + "</a></div>\n" +
                            "                    <div class=\"price\">\n" +
                            "                    \t<font>￥<span>" + history.PRICE + "</span></font> &nbsp; " + (history.PRICE * 0.6).toFixed(2) + "R\n" +
                            "                    </div>\n" +
                            "                </li>";
                    }
                    $("#hist").html(historyhtml);
                }
            }
        })
    }

    var index = 1;

    function deleteallhist(){
        $.ajax({
            async: false,
            type: "post",
            url: "history.z",
            data: {action: "deleteallhist"},
            dataType: "json",
            success: function (result) {
                console.log(result);
                $(".histhist").remove();
            }
        })
    }
    // var producthtmls="";
    /**
     * 根据价格区间来分类显示商品
     * @param mix   最小价格
     * @param max   最大价格
     */
    function xiaoliang(mix, max) {
        if (currentpagecate > totalPagecate) {
            currentpagecate = totalPagecate;
        } else if (currentpagecate < 1) {
            currentpagecate = 1;
        }
        if (totalPagecate < 1) {
            totalPagecate = 1;
        }
        var catehtml = "";
        var pagespart = "";
        var shtml = "";
        if (index > 2) {
            index = 1;
        }
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {
                action: "price",
                "order": index,
                currentpagecate: currentpagecate,
                "mixPrice": mix,
                "maxPrice": max,
                search: (search == null || search == "") ? (cname == null || cname == "" ? search : cname) : search,
                flag: search == null || search == "" ? true : (cname == null || cname == "" ? true : false)
            },
            dataType: "json",
            success: function (result) {
                shtml = result.totalMessage;
                for (var product of result.list) {
                    catehtml += "<li>\n" +
                        "<div class='img'><a href='catelist?action=pagetiao&idd=" + product.ID + "'><img src='" + product.FILENAME + "' width='210' height='185' /></a></div>\n" +
                        "<div class='price'>\n" +
                        "<font>￥<span>" + product.price + "</span></font> &nbsp;" + Math.ceil(product.price * 0.6) + "R\n" +
                        "</div>\n" +
                        "<div class='name'><a href='#'>" + product.DESCRIPTION + "</a></div>\n" +
                        "<div class='carbg'>\n";
                        if (!ifshoucang(product.ID)) {
                            catehtml += "<a onclick='shoudianji(this," + product.ID + ")' class='ss' style='color:#ff4e00;" +
                                "background: url(images/heart_h.png) no-repeat 10px center;'>"+"收藏</a>";
                        } else {
                            catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss'>收藏</a>\n";
                        }
                        catehtml += "<a href='catelist?action=pagetiao&idd=" + product.ID + "' class='j_car'>加入购物车</a>\n" +
                        "</div>\n" +
                        "</li>\n";
                }
                totalPagecate = result.totalPage;
                pagespart += "<p class=\"pagespap left\"><span class=\"red left\">" + (currentpagecate == 0 ? 1 : currentpagecate) + "</span><font class='left'>/" + (totalPagecate == 0 ? 1 : totalPagecate) + "</font></p>" +
                    "                        <a href=\"javascript:pagecatelist('back'," + mix + "," + max + ")\" class=\"p_pre left\">上一页</a><a href=\"javascript:pagecatelist('first'," + mix + "," + max + ")\" class='left'>首页</a><form action=\"javascript:pagem(," + mix + "," + max + ")\" method=\"post\" class='left'>\n" +
                    "                        <input type=\"text\" name=\"pagepp\" pattern=\"^[0-9]*$\" id=\"pagepp\"placeholder=\"请输入跳转到几页\">\n" + "<div class='dds' style='display:none'>请输入符合规范的数据</div>" +
                    "                        <input type=\"submit\" value=\"确定\">\n" +
                    "                    </form><a href=\"javascript:pagecatelist('last'," + mix + "," + max + ")\" class='left'>尾页</a><a href=\"javascript:pagecatelist('next'," + mix + "," + max + ")\" class=\"p_pre left\">下一页</a>\n";
                $(".cate_list").html(catehtml);
                $(".pages").html(pagespart);
            }
        })


        index += 1;
        $(".l_list .list_t .faxian").html("共发现" + shtml + "件");
        $("#productMenu").html(producthtmls);
    }

    //收藏的标记位
    var inde = 0;

    /*
     *  判断是否收藏的ajax方法
     */
    function shoudianji(under, productid) {
        $.ajax({
            async: false,
            type: "post",
            url: "favorite",
            data: {action: "addfavoriter", productid: productid},
            dataType: "json",
            success: function (result) {
                if (result) {
                    $(under).css({
                        "color": "#ff4e00",
                        "background": "url(images/heart_h.png) no-repeat 10px center",
                        "width": "68px",
                        "height": "28px",
                        "line-height": "28px",
                        "overflow": "hidden",
                        "text-indent": "33px",
                        "float": "left",
                        "display": "inline",
                        "margin-right": "-1px",
                        "border": "1px solid #cccccc"
                    })
                } else {
                    $(under).css({
                        "width": "68px",
                        "height": "28px",
                        "line-height": "28px",
                        "overflow": "hidden",
                        "text-indent": "33px",
                        "float": "left",
                        "display": "inline",
                        "margin-right": "-1px",
                        "border": "1px solid #cccccc",
                        "color": "#888888", "background": "url(images/heart.png) no-repeat 10px center"
                    })
                    deleteshoucangajax(productid);
                }
                return;
            }
        })
    }

    //加入购物车亮的方法
    function shoucang() {
        $("#catelist li .carbg .j_car").hover(function () {
            $(this).css({
                "color": "#FFF",
                "background": "url(images/cars_h.png) no-repeat 24px center",
                "background-color": "#ff4e00",
                "border": "1px solid #ff4e00"
            });
        }, function () {
            $(this).css({
                "color": "#ff4e00",
                "background": "url(images/cars.png) no-repeat 24px center",
                "width": "138px",
                "height": "28px",
                "line-height": "28px",
                "overflow": "hidden",
                "text-indent": "47px",
                "float": "left",
                "display": "inline",
                "margin-right": "-1px",
                "border": "1px solid #cccccc"
            });
        })
    }

    function ifshoucang(productid) {
        var flagsc = true;
        $.ajax({
            async: false,
            type: "post",
            url: "favorite",
            data: {action: "onefav", productid: productid},
            dataType: "json",
            success: function (result) {
                flagsc = result;
            }
        })
        return flagsc;
    }

    /*
    * 删除的ajax方法
    * */
    function deleteshoucangajax(productid) {
        $.ajax({
            async: false,
            type: "post",
            url: "favorite",
            data: {action: "deletefavorite", productid: productid},
            dataType: "json",
            success: function (result) {

            }
        })
    }

    /**
     * 根据新品时间来显示商品
     */
    function createtime() {
        if (currentpagecate > totalPagecate) {
            currentpagecate = totalPagecate;
        } else if (currentpagecate < 1) {
            currentpagecate = 1;
        }
        if (totalPagecate < 1) {
            totalPagecate = 1;
        }
        var catehtml = "";
        var pagespart = "";
        var shtml = "";
        if (index > 2) {
            index = 1;
        }
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {
                action: "docreate",
                "order": index,
                currentpagecate: currentpagecate,
                search: search == null || search == "" ? (cname == null || cname == "" ? search : cname) : search,
                flag: search == null || search == "" ? true : (cname == null || cname == "" ? true : false)
            },
            dataType: "json",
            success: function (result) {
                shtml = result.totalMessage;
                for (var product of result.list) {
                    catehtml += "<li>\n" +
                        "<div class='img'><a href='catelist?action=pagetiao&idd=" + product.ID + "'><img src='" + product.FILENAME + "' width='210' height='185' /></a></div>\n" +
                        "<div class='price'>\n" +
                        "<font>￥<span>" + product.price + "</span></font> &nbsp;" + Math.ceil(product.price * 0.6) + "R\n" +
                        "</div>\n" +
                        "<div class='name'><a href='#'>" + product.DESCRIPTION + "</a></div>\n" +
                        "<div class='carbg'>\n";
                    if (!ifshoucang(product.ID)) {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss' style='color:#ff4e00;\n" +
                            "background: url(images/heart_h.png) no-repeat 10px center;'>"+"收藏</a>";
                    } else {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss'>收藏</a>\n";
                    }
                    catehtml += "<a href='catelist?action=pagetiao&idd=" + product.ID + "' class='j_car'>加入购物车</a>\n" +
                        "</div>\n" +
                        "</li>\n";
                }
                totalPagecate = result.totalPage;
                pagespart += "<p class=\"pagespap left\"><span class=\"red left\">" + (currentpagecate == 0 ? 1 : currentpagecate) + "</span><font class='left'>/" + (totalPagecate == 0 ? 1 : totalPagecate) + "</font></p>" +
                    "                        <a href=\"javascript:pagecatelist('back')\" class=\"p_pre left\">上一页</a><a href=\"javascript:pagecatelist('first')\" class='left'>首页</a><form action=\"javascript:pagem()\" method=\"post\" class='left'>\n" +
                    "                        <input type=\"text\" name=\"pagepp\" pattern=\"^[0-9]*$\" id=\"pagepp\"placeholder=\"请输入跳转到几页\">\n" + "<div class='dds' style='display:none'>请输入符合规范的数据</div>" +
                    "                        <input type=\"submit\" value=\"确定\">\n" +
                    "                    </form><a href=\"javascript:pagecatelist('last')\" class='left'>尾页</a><a href=\"javascript:pagecatelist('next')\" class=\"p_pre left\">下一页</a>\n";
                $(".cate_list").html(catehtml);
                $(".pages").html(pagespart);
            }
        })
        index += 1;
        $(".l_list .list_t .faxian").html("共发现" + shtml + "件");
        $("#productMenu").html(producthtmls);
    }

    /**
     * 根据销量进行排名
     */
    function Sales() {
        if (currentpagecate > totalPagecate) {
            currentpagecate = totalPagecate;
        } else if (currentpagecate < 1) {
            currentpagecate = 1;
        }
        if (totalPagecate < 1) {
            totalPagecate = 1;
        }
        var catehtml = "";
        var pagespart = "";
        var shtml = "";
        if (index > 2) {
            index = 1;
        }
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {
                action: "doSales",
                "order": index,
                currentpagecate: currentpagecate,
                search: search == null || search == "" ? (cname == null || cname == "" ? search : cname) : search,
                flag: search == null || search == "" ? true : (cname == null || cname == "" ? true : false)
            },
            dataType: "json",
            success: function (result) {
                shtml = result.totalMessage;
                $(".l_list .list_t fr").html("共发现" + result.totalMessage + "件");
                for (var product of result.list) {
                    catehtml += "<li>\n" +
                        "<div class='img'><a href='catelist?action=pagetiao&idd=" + product.ID + "'><img src='" + product.FILENAME + "' width='210' height='185' /></a></div>\n" +
                        "<div class='price'>\n" +
                        "<font>￥<span>" + product.price + "</span></font> &nbsp;" + Math.ceil(product.price * 0.6) + "R\n" +
                        "</div>\n" +
                        "<div class='name'><a href='#'>" + product.DESCRIPTION + "</a></div>\n" +
                        "<div class='carbg'>\n";
                    if (!ifshoucang(product.ID)) {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss' style='color:#ff4e00;\n" +
                            "background: url(images/heart_h.png) no-repeat 10px center;'>"+"收藏</a>";
                    } else {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss'>收藏</a>\n";
                    }
                    catehtml += "<a href='catelist?action=pagetiao&idd=" + product.ID + "' class='j_car'>加入购物车</a>\n" +
                        "</div>\n" +
                        "</li>\n";
                }
                totalPagecate = result.totalPage;
                pagespart += "<p class=\"pagespap left\"><span class=\"red left\">" + (currentpagecate == 0 ? 1 : currentpagecate) + "</span><font class='left'>/" + (totalPagecate == 0 ? 1 : totalPagecate) + "</font></p>" +
                    "                        <a href=\"javascript:pagecatelist('back')\" class=\"p_pre left\">上一页</a><a href=\"javascript:pagecatelist('first')\" class='left'>首页</a><form action=\"javascript:pagem()\" method=\"post\" class='left'>\n" +
                    "                        <input type=\"text\" name=\"pagepp\" pattern=\"^[0-9]*$\" id=\"pagepp\"placeholder=\"请输入跳转到几页\">\n" + "<div class='dds' style='display:none'>请输入符合规范的数据</div>" +
                    "                        <input type=\"submit\" value=\"确定\">\n" +
                    "                    </form><a href=\"javascript:pagecatelist('last')\" class='left'>尾页</a><a href=\"javascript:pagecatelist('next')\" class=\"p_pre left\">下一页</a>\n";
                $(".cate_list").html(catehtml);
                $(".pages").html(pagespart);
            }
        })
        index += 1;
        $(".l_list .list_t .faxian").html("共发现" + shtml + "件");
        $("#productMenu").html(producthtmls);
    }
</script>
<%--类型展示脚本--%>
<script>
    var cateshtml = "";

    function funcx() {
        $(".n_ch").hide();
        cname = "";
        search = "";
        cateajax();
    }

    $(function () {
        tablechoice();
        tablechoice2();
        tablechoice3();
        funnnnn();
    })

    //品牌类型
    function tablechoice() {
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {action: "table3"},
            dataType: "json",
            success: function (result) {
                if (result == false && result.size != 0) {
                } else {
                    cateshtml += "\"<tr valign='top' id='cate1'>\"+\n" +
                        "                    \"<td width='70'>&nbsp; 分类：</td>\"+\n" +
                        "<td class='td_a'>";
                    for (var category of result) {
                        cateshtml += "<a href='indexServlet?action=ty&cname=" + category.NAME + "&carid=" + category.ID + "'>" + category.NAME + "</a>";
                    }
                    cateshtml += "</td></tr>;"
                    // $(".choice").html(cateshtml);
                }
            }
        })
        cateshtml += "<tr valign=\"top\" id=\"price\">\n" +
            "                <td>&nbsp; 价格：</td>\n" +
            "                <td class=\"td_a\"><a href='javascript:xiaoliang(0,199)'>0-199</a><a href='javascript:xiaoliang(200,399)'>200-399</a><a href='javascript:xiaoliang(400,599)'>400-599</a><a\n" +
            "                        href='javascript:xiaoliang(600,899)'>600-899</a><a href='javascript:xiaoliang(900,1299)'>900-1299</a><a href='javascript:xiaoliang(1300,1399)'>1300-1399</a><a href='javascript:xiaoliang(1400,99999999)'>1400以上</a></td>\n" +
            "            </tr>";
        $(".n_ch").show();
    }

    // 类型中的点击效果
    function funnnnn() {
        $(".td_a a").click(function () {
            $(this).addClass("now");
            $(this).siblings().removeClass("now");
        })
    }

    // 类型二的展示
    function tablechoice2() {
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {action: "table"},
            dataType: "json",
            success: function (result) {

                if (result == false && result.size != 0) {
                } else {
                    cateshtml += "\"<tr valign='top' id='cate3'>\"+\n" +
                        "                    \"<td width='70'>&nbsp; 类型：</td>\"+\n" +
                        "<td class='td_a'>";
                    for (var category of result) {
                        cateshtml += "<a href='indexServlet?action=doty2&cname=" + category.NAME + "&carid=" + category.ID + "'>" + category.NAME + "</a>";
                    }
                    cateshtml += "</td></tr>;"
                    // $(".choice").html(cateshtml);
                }
            }
        })
        $(".n_ch").show();
    }

    // 类型3的展示
    function tablechoice3() {
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {action: "table2"},
            dataType: "json",
            success: function (result) {

                if (result == false && result.size != 0) {
                } else {
                    cateshtml += "\"<tr valign='top' id='cate4'>\"+\n" +
                        "                    \"<td width='70'>&nbsp; 规格：</td>\"+\n" +
                        "<td class='td_a'>";
                    for (var category of result) {
                        cateshtml += "<a href='indexServlet?action=ty&cname=" + category.NAME + "&carid=" + category.ID + "'>" + category.NAME + "</a>";
                    }
                    cateshtml += "</td></tr>;"
                }
            }
        })
        $(".choice").html(cateshtml);
        $(".n_ch").show();
    }
</script>
<%--分页脚本--%>
<script>

    $(function () {

    })
    //标记位
    var iprice = 0;

    //翻页方法
    function pagecatelist(catepage, mix, max) {
        var val = $(".mar_20 .l_list .list_or .now").attr("value");
        if ("next" == catepage) {
            if (currentpagecate == totalPagecate) {
                currentpagecate = totalPagecate
            } else {
                currentpagecate += 1;
            }
            if (val == 0) {
                cateajax();
            } else if (val == 1) {
                Sales();
                // index-=1;
            } else if (val == 2) {
                xiaoliang(mix, max);
                // index-=1;
            } else {
                createtime();
                // index-=1;
            }
        } else if ("back" == catepage) {
            if (currentpagecate == 1) {
                currentpagecate = 1;
            } else {
                currentpagecate -= 1;
            }
            if (val == 0) {
                cateajax();
            } else if (val == 1) {
                Sales();
            } else if (val == 2) {
                xiaoliang(mix, max);
                // index-=1;
                // cateajax();
            } else {
                createtime();
            }
        }
        if ("first" == catepage) {
            currentpagecate = 1;
            if (val == 0) {
                cateajax();
            } else if (val == 1) {
                Sales();
            } else if (val == 2) {
                xiaoliang(mix, max);
                // index-=1;
                // cateajax();
            } else {
                createtime();
            }
        } else if ("last" == catepage) {
            currentpagecate = totalPagecate;
            if (val == 0) {
                cateajax();
            } else if (val == 1) {
                Sales();
            } else if (val == 2) {
                xiaoliang(mix, max);
                // index-=1;
                // cateajax();
            } else {
                createtime();
            }
        }
    }

    /**
     * 根据品牌查找商品集合
     */
    function cateajax() {
        if (currentpagecate > totalPagecate) {
            currentpagecate = totalPagecate;
        } else if (currentpagecate < 1) {
            currentpagecate = 1;
        }
        if (totalPagecate < 1) {
            totalPagecate = 1;
        }
        var catehtml = "";
        var pagespart = "";
        var shtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "catelist",
            data: {
                action: "page",
                currentpagecate: currentpagecate,
                search: search == null || search == "" ? (cname == null || cname == "" ? search : cname) : search,
                flag: search == null || search == "" ? (cname == null || cname == "" ? true : false) : true
            },
            dataType: "json",
            success: function (result) {
                shtml = result.totalMessage;
                for (var product of result.list) {
                    catehtml += "<li>\n" +
                        "<div class='img'><a href='catelist?action=pagetiao&idd=" + product.ID + "'><img src='" + product.FILENAME + "' width='210' height='185' /></a></div>\n" +
                        "<div class='price'>\n" +
                        "<font>￥<span>" + product.price + "</span></font> &nbsp;" + Math.ceil(product.price * 0.6) + "R\n" +
                        "</div>\n" +
                        "<div class='name'><a href='catelist?action=pagetiao&idd=" + product.ID + "'>" + product.DESCRIPTION + "</a></div>\n" +
                        "<div class='carbg'>\n";
                    if (!ifshoucang(product.ID)) {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss' style='color:#ff4e00;\n" +
                            "background: url(images/heart_h.png) no-repeat 10px center;'>"+"收藏</a>";
                    } else {
                        catehtml += "<a onclick='shoudianji(this," + product.ID + ")'class='ss'>收藏</a>\n";
                    }
                    catehtml += "<a href='catelist?action=pagetiao&idd=" + product.ID + "' class='j_car'>加入购物车</a>\n" +
                        "</div>\n" +
                        "</li>\n";
                }
                totalPagecate = result.totalPage;
                pagespart += "<p class=\"pagespap left\"><span class=\"red left\">" + (currentpagecate == 0 ? 1 : currentpagecate) + "</span><font class='left'>/" + (totalPagecate == 0 ? 1 : totalPagecate) + "</font></p>" +
                    "                        <a href=\"javascript:pagecatelist('back')\" class=\"p_pre left\">上一页</a><a href=\"javascript:pagecatelist('first')\" class='left'>首页</a><form action=\"javascript:pagem()\" method=\"post\" class='left'>\n" +
                    "                        <input type=\"text\" name=\"pagepp\" pattern=\"^[0-9]*$\" id=\"pagepp\"placeholder=\"请输入跳转到几页\">\n" + "<div class='dds' style='display:none'>请输入符合规范的数据</div>" +
                    "                        <input type=\"submit\" value=\"确定\">\n" +
                    "                    </form><a href=\"javascript:pagecatelist('last')\" class='left'>尾页</a><a href=\"javascript:pagecatelist('next')\" class=\"p_pre left\">下一页</a>\n";
                $(".cate_list").html(catehtml);
                $(".pages").html(pagespart);
            }
        })
        $(".l_list .list_t .faxian").html("共发现" + shtml + "件");
    }

    /**
     * 翻页中的输入框效果
     * @param mix   最小价格
     * @param max   最大价格
     */
    function pagem(mix, max) {
        currentpagecate = $("#pagepp").val();
        var val = $(".mar_20 .l_list .list_or .now").attr("value");
        if (currentpagecate > totalPagecate || currentpagecate == 0) {
            $(".dds").fadeIn("slow").delay(500).fadeOut("slow");
        } else {
            if (val == 0) {
                cateajax();
            } else if (val == 1) {
                Sales();
                index -= 1;
            } else if (val == 2) {
                xiaoliang(mix, max);
                index -= 1;
            } else {
                createtime();
                index -= 1;
            }
        }
    }
</script>
<%--通用的脚本代码--%>
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

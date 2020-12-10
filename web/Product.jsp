<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>


    <script type="text/javascript" src="js/n_nav.js"></script>

    <link rel="stylesheet" type="text/css" href="css/ShopShow.css"/>
    <link rel="stylesheet" type="text/css" href="css/MagicZoom.css"/>
    <script type="text/javascript" src="js/MagicZoom.js"></script>

    <script type="text/javascript" src="js/num.js">
        var jq = jQuery.noConflict();
    </script>

    <script type="text/javascript" src="js/p_tab.js"></script>

    <script type="text/javascript" src="js/shade.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
    </style>
    <style type="text/css">
        #tishi {
            position: fixed;
            width: 300px;
            left: 45%;
            top: 20px;
            font-size: 20px;
            background-color: skyblue;
            border-radius: 11px;
            height: 100px;
            line-height: 35px;
            display: none;
        }

        #tishi span {
            margin-left: 10px;
        }

        .tiptip {
            position: fixed;
            width: 150px;
            left: 45%;
            top: 20px;
            font-size: 20px;
            background-color: skyblue;
            border-radius: 11px;
            height: 100px;
            line-height: 35px;
            display: none;
        }

        .tiptip span {
            margin-left: 10px;
        }
    </style>
    <title>商品详情页</title>
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
<div class="tiptip"><span>收藏成功</span></div>
<div class="i_bg">
    <div class="postion">
        <span class="fl"><a href="CategoryList.jsp"> 全部</a> >
            <c:if test="sessionScope.product!=null">
               ${sessionScope.product.CATEGORYLEVEL1ID}<%--美妆个护--%> > ${sessionScope.product.CATEGORYLEVEL2ID}<%--香水--%> > ${sessionScope.product.CATEGORYLEVEL3ID}<%--迪奥--%> > ${sessionScope.product.NAME}<%--迪奥真我香水--%></span>
        </c:if>
    </div>
    <div class="content">

        <div id="tsShopContainer">
            <div id="tsImgS"><a href="${sessionScope.product.FILENAME}" title="Images" class="MagicZoom" id="MagicZoom"><img
                    src="${sessionScope.product.FILENAME}" width="390" height="390"/></a></div>
            <div id="tsPicContainer">
                <div id="tsImgSArrL" onclick="tsScrollArrLeft()"></div>
                <div id="tsImgSCon">
                    <ul>
                        <li onclick="showPic(0)" rel="MagicZoom" class="tsSelectImg"><img
                                src="${sessionScope.product.FILENAME}" tsImgS="images/ps1.jpg" width="79" height="79"/>
                        </li>
                        <li onclick="showPic(1)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      width="79" height="79"/></li>
                        <li onclick="showPic(2)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      width="79" height="79"/></li>
                        <li onclick="showPic(3)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      width="79" height="79"/></li>
                        <li onclick="showPic(4)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      width="79" height="79"/></li>
                        <li onclick="showPic(5)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      width="79" height="79"/></li>
                        <li onclick="showPic(6)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      height="79"/></li>
                        <li onclick="showPic(7)" rel="MagicZoom"><img src="${sessionScope.product.FILENAME}"
                                                                      tsImgS="${sessionScope.product.FILENAME}"
                                                                      height="79"/></li>
                    </ul>
                </div>
                <div id="tsImgSArrR" onclick="tsScrollArrRight()"></div>
            </div>
            <img class="MagicZoomLoading" width="16" height="16" src="images/loading.gif" alt="Loading..."/>
        </div>

        <div class="pro_des">
            <div class="des_name">
                <p>${sessionScope.product.DESCRIPTION}</p>
                “开业巨惠，北京专柜直供”，不光低价，“真”才靠谱！
            </div>
            <div class="des_price">
                本店价格：<b>￥${sessionScope.product.price}</b><br/>
                消费积分：<span><fmt:formatNumber value="${sessionScope.product.price*0.6}"></fmt:formatNumber>R</span>
            </div>
            <div class="des_choice">
                <span class="fl">型号选择：</span>
                <ul id="xinhao">
                    <li class="checked">30ml
                        <div class="ch_img"></div>
                    </li>
                    <li>50ml
                        <div class="ch_img"></div>
                    </li>
                    <li>100ml
                        <div class="ch_img"></div>
                    </li>
                </ul>
            </div>
            <div class="des_choice">
                <span class="fl">颜色选择：</span>
                <ul id="color">
                    <li>红色
                        <div class="ch_img"></div>
                    </li>
                    <li class="checked">白色
                        <div class="ch_img"></div>
                    </li>
                    <li>黑色
                        <div class="ch_img"></div>
                    </li>
                </ul>
            </div>
            <span id="stock"></span>
            <div class="des_share">
                <div class="d_sh">
                    分享
                    <div class="d_sh_bg">
                        <a href="#"><img src="images/sh_1.gif"/></a>
                        <a href="#"><img src="images/sh_2.gif"/></a>
                        <a href="#"><img src="images/sh_3.gif"/></a>
                        <a href="#"><img src="images/sh_4.gif"/></a>
                        <a href="#"><img src="images/sh_5.gif"/></a>
                    </div>
                </div>
                <div class="d_care"><a onclick="shoudianji(this, ${sessionScope.product.ID})">关注商品</a></div>
            </div>
            <div class="des_join">
                <div class="j_nums">
                    <input type="text" value="1" id="amount" name="amount" class="n_ipt"/>
                    <input type="button" value="" onclick="addUpdate(jq(this));" class="n_btn_1"/>
                    <input type="button" value="" onclick="jianUpdate(jq(this));" class="n_btn_2"/>
                </div>
                <c:if test="${sessionScope.user!=null}">
                    <span class="fl"><a id="bon" href="javascript:shoprecord()"><img src="images/j_car.png"/></a></span>
                </c:if>
                <c:if test="${sessionScope.user==null}">
                    <span class="fl"><a href="loadpage.jsp" style="font-size: 24px;">请先登录再进行操作</a></span>
                </c:if>
            </div>
            <div id="tishi"><span></span></div>
        </div>

        <div class="s_brand">
            <div class="s_brand_img"><img src="${sessionScope.product.FILENAME}" width="188" height="132"/></div>
            <div class="s_brand_c"><a href="#">进入品牌专区</a></div>
        </div>


    </div>
    <div class="content mar_20">
        <div class="l_history">
            <div class="fav_t">用户还喜欢</div>
            <ul class="historysss">
            </ul>
        </div>
        <div class="l_list">
            <div class="des_border">
                <div class="des_tit">
                    <ul>
                        <li class="current">推荐搭配</li>
                    </ul>
                </div>
                <div class="team_list">
                    <div class="img"><a href="#"><img src="${sessionScope.product.FILENAME}" width="160" height="140"/></a>
                    </div>
                    <div class="name"><a href="#">${sessionScope.product.DESCRIPTION}</a></div>
                    <div class="price">
                        <div class="checkbox"><input type="checkbox" name="zuhe" checked="checked"/></div>
                        <font>￥<span>${sessionScope.product.price}</span></font> &nbsp; <fmt:formatNumber type="number"
                                                                                                          value="${sessionScope.product.price*0.6}"
                                                                                                          pattern="0.00"
                                                                                                          maxFractionDigits="2"/>
                        R
                    </div>
                </div>
                <div class="team_icon"><img src="images/jia_b.gif"/></div>
                <div class="team_list">
                    <div class="img"><a href="#"><img src="${sessionScope.product.FILENAME}" width="160" height="140"/></a>
                    </div>
                    <div class="name"><a href="#">${sessionScope.product.DESCRIPTION}</a></div>
                    <div class="price">
                        <div class="checkbox"><input type="checkbox" name="zuhe"/></div>
                        <font>￥<span>${sessionScope.product.price}</span></font> &nbsp; <fmt:formatNumber type="number"
                                                                                                          value="${sessionScope.product.price*0.6}"
                                                                                                          pattern="0.00"
                                                                                                          maxFractionDigits="2"/>
                        R
                    </div>
                </div>
                <div class="team_icon"><img src="images/jia_b.gif"/></div>
                <div class="team_list">
                    <div class="img"><a href="#"><img src="${sessionScope.product.FILENAME}" width="160" height="140"/></a>
                    </div>
                    <div class="name"><a href="#">${sessionScope.product.DESCRIPTION}</a></div>
                    <div class="price">
                        <div class="checkbox"><input type="checkbox" name="zuhe" checked="checked"/></div>
                        <font>￥<span>${sessionScope.product.price}</span></font> &nbsp; <fmt:formatNumber type="number"
                                                                                                          value="${sessionScope.product.price*0.6}"
                                                                                                          pattern="0.00"
                                                                                                          maxFractionDigits="2"/>R
                    </div>
                </div>
                <div class="team_icon"><img src="images/equl.gif"/></div>
                <div class="team_sum">
                    套餐价：￥<span><fmt:formatNumber type="number" value="${sessionScope.product.price*2.2}" pattern="0.00"
                                                 maxFractionDigits="2"/></span><br/>
                    <input type="text" value="1" class="sum_ipt" readonly/><br/>
                    <a href="#"><img src="images/z_buy.gif"/></a>
                </div>

            </div>
            <div class="des_border">
                <div class="des_tit">
                    <ul>
                        <li class="current"><a href="#p_attribute">商品属性</a></li>
                        <li><a href="#p_details">商品详情</a></li>
                        <li><a href="#p_comment">商品评论</a></li>
                    </ul>
                </div>
                <div class="des_con" id="p_attribute">

                    <table border="0" align="center" style="width:100%; font-family:'宋体'; margin:10px auto;"
                           cellspacing="0" cellpadding="0">
                        <tr>
                            <td>商品名称：${sessionScope.product.NAME}</td>
                            <td>商品编号：1546211</td>
                            <td>品牌： ${sessionScope.product.NAME}</td>
                            <td>上架时间：${sessionScope.product.CREATEDATE} </td>
                        </tr>
                        <tr>
                            <td>商品毛重：160.00g</td>
                            <td>商品产地：法国</td>
                            <td>香调：果香调香型：淡香水/香露EDT</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>容量：1ml-15ml</td>
                            <td>类型：女士香水，Q版香水，组合套装</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>


                </div>
            </div>

            <div class="des_border" id="p_details">
                <div class="des_t">商品详情</div>
                <div class="des_con">
                    <table border="0" align="center" style="width:745px; font-size:14px; font-family:'宋体';"
                           cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="265"><img src="${sessionScope.product.FILENAME}" width="206" height="412"/></td>
                            <td>
                                <b>${sessionScope.product.DESCRIPTION}</b><br/>
                                <%--                            【商品规格】：5ml<br />--%>
                                【商品质地】：液体<br/>
                                【商品日期】：与专柜同步更新<br/>
                                【商品产地】：法国<br/>
                                【商品包装】：无外盒 无塑封<br/>
                                【商品香调】：花束花香调<br/>
                                【适用人群】：适合女性（都市白领，性感，有女人味的成熟女性）<br/>
                            </td>
                        </tr>
                    </table>

                    <p align="center">
                        <img src="${sessionScope.product.FILENAME}" width="746" height="425"/><br/><br/>
                        <img src="${sessionScope.product.FILENAME}" width="750" height="417"/><br/><br/>
                        <img src="${sessionScope.product.FILENAME}" width="750" height="409"/><br/><br/>
                        <img src="${sessionScope.product.FILENAME}" width="750" height="409"/>
                    </p>

                </div>
            </div>

            <div class="des_border" id="p_comment">
                <div class="des_t">商品评论</div>

                <table border="0" class="jud_tab" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="175" class="jud_per">
                            <p>80.0%</p>好评度
                        </td>
                        <td width="300">
                            <table border="0" style="width:100%;" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="90">好评<font color="#999999">（80%）</font></td>
                                    <td><img src="images/pl.gif" align="absmiddle"/></td>
                                </tr>
                                <tr>
                                    <td>中评<font color="#999999">（20%）</font></td>
                                    <td><img src="images/pl.gif" align="absmiddle"/></td>
                                </tr>
                                <tr>
                                    <td>差评<font color="#999999">（0%）</font></td>
                                    <td><img src="images/pl.gif" align="absmiddle"/></td>
                                </tr>
                            </table>
                        </td>
                        <td width="185" class="jud_bg">
                            购买过雅诗兰黛第六代特润精华露50ml的顾客，在收到商品才可以对该商品发表评论
                        </td>
                        <td class="jud_bg">您可对已购买商品进行评价<br/><a href="#"><img src="images/btn_jud.gif"/></a></td>
                    </tr>
                </table>


                <table border="0" class="jud_list" style="width:100%; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="160"><img src="images/peo1.jpg" width="20" height="20" align="absmiddle"/>&nbsp;向死而生
                        </td>
                        <td width="180">
                            颜色分类：<font color="#999999">粉色</font> <br/>
                            型号：<font color="#999999">50ml</font>
                        </td>
                        <td>
                            产品很好，香味很喜欢，必须给赞。 <br/>
                            <font color="#999999">2015-09-24</font>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td width="160"><img src="images/peo2.jpg" width="20" height="20" align="absmiddle"/>&nbsp;就是这么想的
                        </td>
                        <td width="180">
                            颜色分类：<font color="#999999">粉色</font> <br/>
                            型号：<font color="#999999">50ml</font>
                        </td>
                        <td>
                            送朋友，她很喜欢，大爱。 <br/>
                            <font color="#999999">2015-09-24</font>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td width="160"><img src="images/peo3.jpg" width="20" height="20" align="absmiddle"/>&nbsp;墨镜墨镜
                        </td>
                        <td width="180">
                            颜色分类：<font color="#999999">粉色</font> <br/>
                            型号：<font color="#999999">50ml</font>
                        </td>
                        <td>
                            大家都说不错<br/>
                            <font color="#999999">2015-09-24</font>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td width="160"><img src="images/peo4.jpg" width="20" height="20" align="absmiddle"/>&nbsp;那*****洋
                            <br/><font color="#999999">（匿名用户）</font></td>
                        <td width="180">
                            颜色分类：<font color="#999999">粉色</font> <br/>
                            型号：<font color="#999999">50ml</font>
                        </td>
                        <td>
                            下次还会来买，推荐。<br/>
                            <font color="#999999">2015-09-24</font>
                        </td>
                    </tr>
                </table>


                <div class="pages">
                    <%--                    <a href="#" class="p_pre">上一页</a><a href="#" class="cur">1</a><a href="#">2</a><a href="#">3</a>...<a href="#">20</a><a href="#" class="p_pre">下一页</a>--%>
                </div>

            </div>


        </div>
    </div>
    <!--Begin 弹出层-收藏成功 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img
                        src="images/close.gif"/></span>
            </div>
            <div class="notice_c">

                <table border="0" align="center" style="margin-top:;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="40"><img src="images/suc.png"/></td>
                        <td>
                            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;">您已成功收藏该商品</span><br/>
                            <a href="#">查看我的关注 >></a>
                        </td>
                    </tr>
                    <tr height="50" valign="bottom">
                        <td>&nbsp;</td>
                        <td><a href="#" class="b_sure">确定</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!--End 弹出层-收藏成功 End-->
    <!--Begin 弹出层-加入购物车 Begin-->
    <div id="fade1" class="black_overlay"></div>
    <div id="MyDiv1" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img
                        src="images/close.gif"/></span>
            </div>
            <div class="notice_c">

                <table border="0" align="center" style="margin-top:;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="40"><img src="images/suc.png"/></td>
                        <td id="addt" class="addtd">
                            <%--                    	<span style="color:#3e3e3e; font-size:18px; font-weight:bold;">宝贝已成功添加到购物车</span><br />--%>
                            <%--                    	购物车共有1种宝贝（3件） &nbsp; &nbsp; 合计：1120元--%>
                        </td>
                    </tr>
                    <tr height="50" valign="bottom">
                        <td>&nbsp;</td>
                        <td id="tiaozhuan"><a href="#" class="b_sure">去购物车结算</a><a href="#" class="b_buy">继续购物</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!--End 弹出层-加入购物车 End-->
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
<script src="js/ShopShow.js"></script>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
<script>
    function history() {
        var historyhtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "history.z",
            data: {action: "gethistory", userid:${sessionScope.user.id==null?null:sessionScope.user.id}},
            dataType: "json",
            success: function (result) {
                if (result != null) {
                    for (var history of result) {
                        historyhtml += "<li>\n" +
                            "                    <div class=\"img\"><a href=\"catelist?action=pagetiao&idd=" + history.PRODUCTID + "\"><img src='" + history.FILENAME + "' width=\"185\" height=\"162\" /></a></div>\n" +
                            "                \t<div class=\"name\"><a href=\"catelist?action=pagetiao&idd=" + history.PRODUCTID + "\">" + history.DESPCRIPTION + "</a></div>\n" +
                            "                    <div class=\"price\">\n" +
                            "                    \t<font>￥<span>" + history.PRICE + "</span></font> &nbsp; " + (history.PRICE * 0.6).toFixed(2) + "R\n" +
                            "                    </div>\n" +
                            "                </li>";
                    }
                    $(".historysss").html(historyhtml);
                }
            }
        })
    }

    function fun() {
        $("#amount").blur(function () {
            var asum = $("#amount").val();
            if (asum > 999) {
                $("#tishi span").html("单次添加最多999件");
                asum = 999;
                $("#amount").val("999");
                $("#tishi").show("slow").delay(500).hide("slow");
            } else if (asum < 1) {
                $("#tishi span").html("最少添加1件");
                $("#amount").val("1");
                asum = 1;
                $("#tishi").show("slow").delay(500).hide("slow");
            }
        })
    }

    $(function () {
        color();
        xinhao();
        history();
        $("#xinhao li:first").addClass("checked");
        $("#color li:first").addClass("checked");
        stock();
        $("#xinhao li").click(function () {
            $(this).addClass("checked");
            $(this).siblings().removeClass("checked")
            stock();
        })
        $("#color li").click(function () {
            $(this).addClass("checked");
            $(this).siblings().removeClass("checked");
            stock();
        })
        ctpan();
        fun();
    })

    function ctpan() {
        if ($("#color").html() == "" || $("#color").html() == null) {
            $(".des_choice").hide();
            $("#stock").html("不好意思，该商品暂时缺货");
        }
        if ($("#xinhao").html() == "" || $("#xinhao").html() == null) {
            $(".des_choice").hide();
            $("#stock").html("不好意思，该商品暂时缺货");
        }
    }

    function color() {
        var colorhtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "product",
            data: {action: "color", product:${sessionScope.product.ID==null?"1":sessionScope.product.ID}},
            dataType: "json",
            success: function (result) {
                if (result != null) {
                    for (var color of result) {
                        colorhtml += "<li>" + color + "<div class='ch_img'></div></li>";
                    }
                    $("#color").html(colorhtml);
                }
            }
        })

    }

    function xinhao() {
        var xiaohaohtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "product",
            data: {action: "type", product:${sessionScope.product.ID==null?"":sessionScope.product.ID}},
            dataType: "json",
            success: function (result) {
                if (result != null) {
                    for (var type of result) {
                        xiaohaohtml += "<li>" + type + "<div class='ch_img'></div></li>";
                    }
                    $("#xinhao").html(xiaohaohtml);
                } else {
                    $("#xinhao").attr("disabled", "disabled");
                }
            }
        })

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
    function shoudianji(under, productid) {
        $.ajax({
            async: false,
            type: "post",
            url: "favorite",
            data: {action: "addfavoriter", productid: productid},
            dataType: "json",
            success: function (result) {
                if (result) {
                    $(".tiptip span").html("收藏成功");
                    $(".tiptip").fadeIn("slow").delay(500).fadeOut("slow");
                } else {
                    deleteshoucangajax(productid);
                    $(".tiptip span").html("已删除收藏");
                    $(".tiptip").fadeIn("slow").delay(500).fadeOut("slow");
                }
                return;
            }
        })
    }

    var stocks = 0;

    function stock() {
        var stockhtml = "";
        $.ajax({
            async: false,
            type: "post",
            url: "product",
            data: {
                action: "stock",
                product:${sessionScope.product.ID==null?"":sessionScope.product.ID},
                color: $("#color .checked").text(),
                type: $("#xinhao .checked").text()
            },
            dataType: "json",
            success: function (result) {
                if (result != null) {
                    stockhtml = result;
                    stocks = result;
                } else {
                    stockhtml = "该商品暂时缺货不好意思。"
                }
            }
        })
        $("#stock").html("该商品类型库存：" + stockhtml);
    }

    function shoprecord() {
        if (stocks != 0) {
            var shoptip = "";
            $.ajax({
                async: false,
                type: "post",
                url: "product",
                data: {
                    action: "record",
                    productid:${sessionScope.product.ID==null?"":sessionScope.product.ID},
                    amount: $("#amount").val(),
                    userid:${sessionScope.user.id==null?false:sessionScope.user.id},
                    color: $("#color .checked").text(),
                    type: $("#xinhao .checked").text()
                },
                dataType: "json",
                success: function (result) {
                    if (result == false) {
                        shoptip = "宝贝已成功添加到购物车😊😊\n";
                    } else {
                        shoptip = "添加失败"
                    }
                }
            })
            $("#tishi span").html(shoptip);
            $("#tishi").show("slow").delay(500).hide("slow");
            shoppingrecord();
        }else{
            shoptip = "库存不够，添加失败";
            $("#tishi span").html(shoptip);
            $("#tishi").show("slow").delay(500).hide("slow");
        }
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

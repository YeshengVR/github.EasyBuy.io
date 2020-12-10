<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
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

    <script type="text/javascript" src="js/n_nav.js"></script>

    <script type="text/javascript" src="js/num.js">
        var jq = jQuery.noConflict();
    </script>

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
        .nuw{width:211px; text-decoration:none; height:40px; line-height:40px; background-color:#FFF; color:#ff4e00; z-index:800; }
        .acd{display: block;position: absolute;top: 0px;}
        .zj{ display: block;}
        .leftNav{display: none;}
        .zj_l_c a{color: brown;}
        .fl1 a{color:aliceblue;}
    </style>

    <style>
        #titi{
            border-radius: 11px;
            height: 35px;
            line-height: 35px;
            position: fixed;
            left: 50%;
            top: 20px;
            font-size: 24px;
            padding: 20px;
            background-color: rgba(135, 206, 235,0.5);
            display:none;       }
        #titi span{
            /*background-color: rgba(135, 206, 235,0.5);*/
        }
        .ldd{
            width: 38px;
            float: left;
            outline: none;
            border: none;
        }
        .stockcl{
            position: relative;
        }
        #sto{
            margin: 50px auto;
            width: 200px;
            padding: 10px;
            line-height: 60px;
            background-color: skyblue;
            border-radius: 20px;
            display: none;
            top: 0px;
            position: fixed;
            z-index: 10000;
            left: 45%;
        }
        #sto span{
            font-size: 20px;
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
    <title>购物车页面</title>
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
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
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
        	<span class="fl">你好，${sessionScope.user==null?"<a href='loadpage.jsp'>登录</a>":sessionScope.user.loginname}&nbsp;&nbsp;&nbsp;${sessionScope.user==null?"<a href='registerpage.jsp'>免费注册</a>":"<a href='login.do?action=layout'>退出登录</a>"}|&nbsp;<a href="Order.jsp">我的订单</a>&nbsp;|</span>
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
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="top">
    <div class="logo"><a href="index.jsp"><img src="images/logo.png" /></a></div>
    <div class="search">
        <form action="catelist?action=search" method="post" id="search">
            <input type="text" value="" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
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
    <div class="content mar_20">
        <img src="images/img1.jpg"/>
    </div>
    <div id="titi"><span></span></div>
    <!--Begin 第一步：查看购物车 Begin -->
    <div id="sto"><span> 购买数量不能大于库存</span></div>
    <div class="content mar_20">
        <table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
        </table>

    </div>
    <!--End 第一步：查看购物车 End-->
<script type="text/javascript">
    var tablb =0;
</script>

    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img
                        src="images/close.gif"/></span>
            </div>
            <div class="notice_c">

                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td>您确定要把该商品移除购物车吗？</td>
                    </tr>
                    <tr height="50" valign="bottom">
                        <td><a href="javascript:deleterecrd(tablb)" class="b_sure">确定</a><a href="javascript:CloseDiv('MyDiv','fade')" class="b_buy">取消</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!--End 弹出层-删除商品 End-->


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
<script>
    // var currentpageshoppage = 1;
    var flaggg =false;
    var gouwuche = "";
    $(function () {
        if(${sessionScope.user!=null?true:false}) {
            gowuchemethod();
        }else{
            falie();
        }
        if(Pannum()){
            $(".addz").html("<a href=\"Buy1.az?action=buy2\"><img src=\"images/buy2.gif\" /></a>");
        }else{
            $(".addz").html("请先进行购买才能进行结算");
        }
    })
    function Pannum(){
        var flags = false;
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "num"},
            dataType: "json",
            success: function (result) {
                flags = result;
            }
        })
        return flags;
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
    function allprice(ththth,id){
        // $("tr input[type='text']").change(function(){
        // var reg = new RegExp("^[0-9]*$");
        var stocks = $(ththth).parent().parent().parent().find("td:first span").text().replace(/[^0-9.]/ig,"");
            var price = $(ththth).parent().find(".hidden").val();
            var amount = $(ththth).parent().find(".ldd").val();
            if(!/^[0-9]*$/.test(amount)){
                $(ththth).parent().find("input[type='text']").val("1");
                $(ththth).val("1");
                amount = 1;
            }else if(amount>parseInt(stocks)){
                $(ththth).parent().find("input[type='text']").val("1");
                $("#sto span").html("购买数量不能大于库存");
                $("#sto").fadeIn("slow").delay(500).fadeOut("slow");
                amount = 1;
            }else if(amount<0||amount>999){
                $(ththth).parent().find("input[type='text']").val("999");///
                $("#sto span").html("单次购买数量不能大于999");
                $("#sto").fadeIn("slow").delay(500).fadeOut("slow");
                amount =999;
            }
            $(ththth).parent().parent().parent().find(".sumsmall").html("￥"+(price*amount).toFixed(2));
        $(ththth).parent().parent().parent().find(".jifen").html((price*0.6*amount).toFixed(2)+"R");
        amountajax(amount,id)
        sumall();
        // })
    }
    function decolor(codeid) {
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "showcolor", codeid: codeid},
            dataType: "json",
            success: function (result) {
                gouwuche += result.PRODUCTCOLOR;
            }
        })
    }
    function despc(productid) {
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "showdesc", productid: productid},
            dataType: "json",
            success: function (result) {
                gouwuche += result.DESCRIPTION;
            }
        })
    }
    function falie(){
        $(".car_tab").html("请先登录在进行操作！<a href='loadpage.jsp'>登录</a>");
    }
    function jians(jian,id){
        var c = $(jian).parent().find(".ldd").val();
        if(c==1){
            c=1;
        }else{
            if(parseInt(c)<=1){
                $("#sto").html("单次购买数量最少1个")
                $("#sto").fadeIn("slow").delay(500).fadeOut("slow");
                c=1;
            }else{
                c=parseInt(c)-1;
            }
            $(jian).parent().find(".ldd").val(c);
        }
        allprice(jian,id);
    }

    function amountajax(amountte,idid){
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "amount",amount:amountte,id:idid},
            dataType: "json",
            success: function (result) {

            }
        })
    }

    function adds(jia,id){
        var c = $(jia).parent().find(".ldd").val();
        var stocks = $(jia).parent().parent().parent().find("td:first span").text().replace(/[^0-9.]/ig,"");
        if(parseInt(c)>999){
            $("#sto").html("单次购买数量不能大于999")
            $("#sto").fadeIn("slow").delay(500).fadeOut("slow");
            $(jia).parent().find(".ldd").val(1);
        }else if(parseInt(c)>parseInt(stocks)){
            $("#sto").html("购买数量不能大于库存")
            $("#sto").fadeIn("slow").delay(500).fadeOut("slow");
            $(jia).parent().find(".ldd").val(1);
        }else {
            c = parseInt(c) + 1;
            $(jia).parent().find(".ldd").val(c);
        }
        allprice(jia,id);
    }
    function gowuchemethod() {
        gouwuche += "<tr>\n" +
            "            <td class=\"car_th\" width=\"490\">商品名称</td>\n" +
            "            <td class=\"car_th\" width=\"140\">属性</td>\n" +
            "            <td class=\"car_th\" width=\"150\">购买数量</td>\n" +
            "            <td class=\"car_th\" width=\"130\">小计</td>\n" +
            "            <td class=\"car_th\" width=\"140\">返还积分</td>\n" +
            "            <td class=\"car_th\" width=\"150\">操作</td>\n" +
            "          </tr>";
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "showrecord"},
            dataType: "json",
            success: function (result) {
                for (var shoprecord of result) {
                    flaggg =true;
                    gouwuche += "<tr class='xdd'>\n" +
                        "            <td>\n" +
                        "            \t<div class=\"c_s_img\"><img src='" +shoprecord.FILENAME+"' width=\"73\" height=\"73\" /></div>\n";
                    despc(shoprecord.PRODUCTID);
                    gouwuche += "<br/><span class='stockcl'>库存："+stockT(shoprecord.CCODEID)+"</span>            </td>\n" +
                        "            <td align=\"center\">颜色：";
                    decolor(shoprecord.CCODEID);
                    gouwuche += "</td>\n" +
                        "            <td align=\"center\">\n" +
                        "            \t<div class=\"c_num\">\n" +
                            ""+
                        "                    <input type=\"button\" value=\"\" onclick=\"jians(this,"+shoprecord.ID+");\" class=\"car_btn_1\" />\n" +
                        "<input  class=\"hidden\" type=\"hidden\" name=\"price\" value='"+(shoprecord.PRICE).toFixed(2)+"'>" +
                        "                \t<input type=\"text\" onblur='allprice(this,"+shoprecord.ID+")' class=\"ldd\" style=\"width: 38px;float: left;outline: none;border: none;\" value='"+shoprecord.AMOUNT+"' name=\"\" class=\"car_ipt\" />  \n" +
                        "                    <input type=\"button\" value=\"\" onclick=\"adds(this,"+shoprecord.ID+");\" class=\"car_btn_2\" />\n" +
                        "</div>\n" +
                        "            </td>\n" +
                        "            <td align=\"center\" style=\"color:#ff4e00;\" class=\"sumsmall\">￥" + (shoprecord.PRICE*shoprecord.AMOUNT).toFixed(2) + "</td>\n" +
                        "            <td align=\"center\" class=\"jifen\">" + (shoprecord.PRICE * 0.6).toFixed(2) + "R</td>\n" +
                        "            <td align=\"center\"><a onclick='javascript:deleterecrd("+shoprecord.ID+",this)'>删除</a>&nbsp; &nbsp;<a href='javascript:shoudianji(this,"+shoprecord.PRODUCTID+")'>加入收藏</a></td>\n" +
                        "          </tr>";
                }
            }
        })
        // "<tr><td></td><td></td><td></td><td></td><td></td><td><span><span class='red' style='color:red;'>"+currentpageshoppage+"</span>/"+totalpageshops+"</span><a href='javascript:gouwupage(\"back\")'>上一页</a><a href='javascript:gouwupage(\"next\")'>下一页</a></td></tr>"
        gouwuche += "<tr height=\"70\">\n" +
            "          \t<td colspan=\"6\" style=\"font-family:'Microsoft YaHei'; border-bottom:0;\">\n" +
            // "            \t<label class=\"r_rad\"><input type=\"checkbox\" name=\"clear\" checked=\"checked\" /></label><label class=\"r_txt\">清空购物车</label>\n" +
                "<a href=\"javascript:deleteallrecord()\">清空购物车</a>"+
            "                <span class=\"fr\">商品总价：<b style=\"font-size:22px; color:#ff4e00;\"  class=\"sumprice\">" + sumss() + ".00</b></span>\n" +
        "            </td>\n" +
        "          </tr>" +
        "<tr valign=\"top\" height=\"150\">\n" +
        "          \t<td colspan=\"6\" align=\"right\">\n" +
        "            \t<a href=\"CategoryList.jsp\"><img src=\"images/buy1.gif\" /></a>&nbsp; &nbsp; <span  class='addz'><a href=\"Buy1.az?action=buy2\"><img src=\"images/buy2.gif\" /></a></span>\n" +
        "            </td>\n" +
        "          </tr>";
        $(".car_tab").html(gouwuche);
        $(".car_tab tr:even").addClass("car_tr");
    }
    function fun1show(shopid){
        tablb = shopid;
        ShowDiv('MyDiv','fade');
    }
    function deleterecrd(recordid,zz){
        var flag = false;
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "deleterecord",recordid:recordid},
            dataType: "json",
            success: function (result) {
                flag = result;
            }
        })
        if(flag){
            $("#titi span").html("删除成功");
            $("#titi").fadeIn("slow").delay(500).fadeOut("slow");
        }else{
            $("#titi span").html("删除失败");
            $("#titi").fadeIn("slow").delay(500).fadeOut("slow");
        }
        $(zz).parent().parent().remove();
        $(".car_tab tr:even").addClass("car_tr");
        shoppingrecord();
        sumall();
        if(Pannum()){
            $(".addz").html("<a href=\"Buy1.az?action=buy2\"><img src=\"images/buy2.gif\" /></a>");
        }else{
            $(".addz").html("请先进行购买才能进行结算");
        }
    }
    function deleteallrecord(){
        var flagdr = false;
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "deleteall"},
            dataType: "json",
            success: function (result) {
                flagdr = result;
            }
        })
        if(flagdr){
            $("#titi span").html("删除成功");
            $("#titi").fadeIn("slow").delay(500).fadeOut("slow");
        }else{
            $("#titi span").html("删除失败");
            $("#titi").fadeIn("slow").delay(500).fadeOut("slow");
        }
        shoppingrecord();
        $(".xdd").remove();
        $(".car_tab tr:even").addClass("car_tr");
        sumall();
        if(Pannum()){
            $(".addz").html("<a href=\"Buy1.az?action=buy2\"><img src=\"images/buy2.gif\" /></a>");
        }else{
            $(".addz").html("请先进行购买才能进行结算");
        }
    }
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
    function sumall(){
        var sumall = 0;
        $(".sumsmall").each(function(){
        // .replace(/[^0-9]/ig,"").toFixed(2)
            sumall+=parseInt($(this).html().replace(/[^0-9.]/ig,""));
        })
        $(".sumprice").html("￥"+sumall.toFixed(2));
        $(".sumprice").text("￥"+sumall.toFixed(2));
        return sumall;
    }
    function stockT(codeid){
        var stock=0;
        $.ajax({
            async: false,
            type: "post",
            url: "Buy1.az",
            data: {action: "stock",codeid:codeid},
            dataType: "json",
            success: function (result) {
                stock = result;
            }
        })
        return stock;
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
package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Service.IUserService;
import com.Project.EasyBuy.User.Service.impl.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/Buy2.az")
public class Buy2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("addAddress".equalsIgnoreCase(action)) {
            addAddress(request, response);
        }else if("modifyAddress".equalsIgnoreCase(action)){
            modifyAddress(request, response);
        }else if("ordersubmit".equalsIgnoreCase(action)){
            ordersubmit(request, response);
        }
    }
    //修改地址信息
    public void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Number id = user.getId();
        String nickname = request.getParameter("name");
        String email = request.getParameter("email");
        String address1 = request.getParameter("address");
        String aDefault = request.getParameter("default");
        String youzheng = request.getParameter("youzheng");
        String moblie = request.getParameter("moblie");
        String remark = request.getParameter("remark");
        Address address = null;
        if("0".equalsIgnoreCase(aDefault)){
            address = new Address(null,id,address1,null,0,remark==null?null:remark,Long.parseLong(moblie),(youzheng==null||youzheng==""?null:Integer.parseInt(youzheng)),nickname==null||nickname==""?null:nickname,(email==null||email==""?null:email));
            userService.AddAddress(address);
            userService.ModifyAddress(address);
            address = userService.ADDRESSByDefault(user);
        }else{
            address = new Address(null,id,address1,null,1,remark==null?null:remark,Long.parseLong(moblie),(youzheng==null||youzheng==""?null:Integer.parseInt(youzheng)),nickname==null||nickname==""?null:nickname,(email==null||email==""?null:email));
            userService.AddAddress(address);
        }
        if(session.getAttribute("address")!=null) {
            session.removeAttribute("address");
        }
//        address = userService.ADDRESSByDefault(user);
        session.setAttribute("address",address);
        response.sendRedirect("BuyCar_Two.jsp");
    }
    //添加地址
    public void modifyAddress(HttpServletRequest request, HttpServletResponse response) throws IOException{
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Number id = user.getId();
        String nickname = request.getParameter("name");
        String email = request.getParameter("email");
        String address1 = request.getParameter("address");
        String aDefault = request.getParameter("default");
        String youzheng = request.getParameter("youzheng");
        String moblie = request.getParameter("moblie");
        String remark = request.getParameter("remark");
        Address address = null;
        if("0".equalsIgnoreCase(aDefault)){
            address = new Address(null,id,address1,null,0,remark==null?null:remark,Long.parseLong(moblie),(youzheng==null||youzheng=="")?null:Integer.parseInt(youzheng),nickname==null?null:nickname,(email==null||email==""?null:email));
            userService.ModifyAddressDefault(id.intValue());
            userService.AddAddress(address);
            address = userService.ADDRESSByDefault(user);
        }else{
            address = new Address(null,id,address1,null,1,remark==null?null:remark,Long.parseLong(moblie),(youzheng==null||youzheng=="")?null:Integer.parseInt(youzheng),nickname==null?null:nickname,(email==null||email==""?null:email));
            userService.AddAddress(address);
        }
        session.removeAttribute("address");

        session.setAttribute("address",address);
        response.sendRedirect("BuyCar_Two.jsp");
    }
    public void ordersubmit(HttpServletRequest request, HttpServletResponse response) throws IOException{
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Address address = (Address)session.getAttribute("address");
        String nickname = address.getNICKNAME();
        ArrayList<ShoppingRecord> shoppingRecords = userService.selectallShop(user.getId().intValue());
        String uuid = uuid();
        ArrayList<OrderDetail> arr = new ArrayList<OrderDetail>();
        Integer sum = 0;
        Boolean flaggg = false;
        for (ShoppingRecord shoppingRecord : shoppingRecords) {
            sum += (shoppingRecord.getPRICE().intValue()*shoppingRecord.getAMOUNT().intValue());
            CCODE stock = userService.Stock(shoppingRecord.getCCODEID());
            if(shoppingRecord.getAMOUNT()!=null&&Integer.parseInt(shoppingRecord.getAMOUNT().toString())!=0) {
                if (shoppingRecord.getAMOUNT().intValue() <= stock.getPRODUCTSTOCK().intValue()) {
                    //更新商品规格类型库存
                    userService.updatestock(shoppingRecord.getAMOUNT(), shoppingRecord.getCCODEID());
                    //更新商品销量
                    userService.updateSales(shoppingRecord.getAMOUNT(), shoppingRecord.getPRODUCTID());
                    flaggg = true;
                } else {
                    flaggg = false;
                }
            }else{
                flaggg = false;
            }
        }
        if(flaggg) {
            Order order = new Order(null, user.getId(), user.getLoginname(), address.getADDRESS(), null, sum, uuid);
            //订单提交
            userService.OrderSubmit(order);
            Order order1 = userService.selectOrder(order);
            for (ShoppingRecord shoppingRecord : shoppingRecords) {
                sum += shoppingRecord.getPRICE().intValue() * shoppingRecord.getAMOUNT().intValue();
                OrderDetail orderDetail = new OrderDetail(null, order1.getID(), shoppingRecord.getPRODUCTID(), shoppingRecord.getAMOUNT(), (shoppingRecord.getAMOUNT().intValue() * shoppingRecord.getPRICE().intValue()));
                arr.add(orderDetail);
            }
            //订单详情提交
            userService.OrderDetailSubmit(arr);
            session.removeAttribute("address");
            session.setAttribute("order", order1);
            session.setAttribute("nickname", nickname);
            session.setAttribute("tab",true);
            response.sendRedirect("BuyCar_Three.jsp");
            return;
        }else{
            session.setAttribute("tab",false);
            response.sendRedirect("BuyCar_Three.jsp");
            return;
        }
    }

    public String uuid(){
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        return str;
    }
}

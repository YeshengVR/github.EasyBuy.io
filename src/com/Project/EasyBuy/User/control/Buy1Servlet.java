package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.*;
import com.Project.EasyBuy.User.Service.IUserService;
import com.Project.EasyBuy.User.Service.impl.UserService;
import com.Project.EasyBuy.User.Util.PageEntry;
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

@WebServlet("/Buy1.az")
public class Buy1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("showrecord".equalsIgnoreCase(action)) {
            showrecord(request, response);
        }else if("showdesc".equalsIgnoreCase(action)){
            showdesc(request, response);
        }else if("showcolor".equalsIgnoreCase(action)){
            showcolor(request, response);
        }else if("deleterecord".equalsIgnoreCase(action)){
            deleterecord(request,response);
        }else if("deleteall".equalsIgnoreCase(action)){
            deleteallrecord(request, response);
        }else if("buy2".equalsIgnoreCase(action)){
            tiaozhuanbuy2(request, response);
        }else if("stock".equalsIgnoreCase(action)){
            dostock(request, response);
        }else if("amount".equalsIgnoreCase(action)){
            doamount(request, response);
        }else if("num".equalsIgnoreCase(action)){
            dopanche(request, response);
        }
    }
    public void deleteallrecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Boolean deleteallrecor = userService.deleteallrecor(user.getId());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(deleteallrecor);
        response.getWriter().print(s);
    }
    public void showrecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<ShoppingRecord> shoppingRecords = userService.selectallShop(user.getId().intValue());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(shoppingRecords);
        response.getWriter().print(s);
    }
    public void showdesc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String productid = request.getParameter("productid");
        Product product = userService.ProductByID("EASYBUY_PRODUCT", "ID",Integer.parseInt(productid));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(product);
        response.getWriter().print(s);
    }
    public void showcolor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String codeid = request.getParameter("codeid");
        CCODE ccode = userService.getid(Integer.parseInt(codeid));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(ccode);
        response.getWriter().print(s);
    }
    public void deleterecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String recordid = request.getParameter("recordid");
        Boolean deleterecord = userService.deleterecord(Integer.parseInt(recordid));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(deleterecord);
        response.getWriter().print(s);
    }
    public void tiaozhuanbuy2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Address address = userService.ADDRESSByDefault(user);
        session.setAttribute("address",address);
        response.sendRedirect("BuyCar_Two.jsp");
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//        String s = gson.toJson(shoppingRecords);
//        response.getWriter().print(s);
    }
    public void dostock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String codeid = request.getParameter("codeid");
        CCODE getid = userService.getid(Integer.parseInt(codeid));
        Number productstock = getid.getPRODUCTSTOCK();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(productstock);
        response.getWriter().print(s);
    }
    public void doamount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String codeid = request.getParameter("codeid");
//        CCODE getid = userService.getid(Integer.parseInt(codeid));
//        Number productstock = getid.getPRODUCTSTOCK();
        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        Boolean aBoolean = userService.updateShoprecordamount(Integer.parseInt(amount), Integer.parseInt(id));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void dopanche(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Boolean flag =false;
        if(user!=null) {
            flag = userService.numrecord(user.getId());
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(flag);
        response.getWriter().print(s);
    }

}
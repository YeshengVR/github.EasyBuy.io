package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.CCODE;
import com.Project.EasyBuy.User.Entry.Product;
import com.Project.EasyBuy.User.Entry.ShoppingRecord;
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
import java.util.HashMap;

@WebServlet("/product")
public class productServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("color".equalsIgnoreCase(action)) {
            docolor(request, response);
            return;
        }else if("type".equalsIgnoreCase(action)){
            doType(request,response);
            return;
        }else if("stock".equalsIgnoreCase(action)){
            doStock(request, response);
            return;
        }else if("record".equalsIgnoreCase(action)){
            doshoprecord(request, response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }

    public void docolor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String id = request.getParameter("product");
        ArrayList<String> color = userService.getColor(Integer.parseInt(id));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(color);
        response.getWriter().print(s);
    }
    public void doType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String id = request.getParameter("product");
        ArrayList<String> color = userService.getspec(Integer.parseInt(id));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(color);
        response.getWriter().print(s);
    }
    public void doStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String id = request.getParameter("product");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        CCODE getstock = userService.getstock(Integer.parseInt(id), color, type);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(getstock==null?null:getstock.getPRODUCTSTOCK());
        response.getWriter().print(s);
    }
    public void doshoprecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String id = request.getParameter("productid");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String userid = request.getParameter("userid");
        Product product = userService.ProductByID("EASYBUY_PRODUCT", "ID", Integer.parseInt(id));
        CCODE code = userService.getstock(Integer.parseInt(id), color, type);
        ShoppingRecord sr = null;
        Boolean isrepeartshoprecord = true;
        if(code!=null) {
            sr = new ShoppingRecord(null, Integer.parseInt(userid), product.getID(), product.getPrice(), Integer.parseInt(amount), null, product.getFILENAME(), code.getID());
            isrepeartshoprecord = userService.isrepeartshoprecord(product.getID(), Integer.parseInt(userid),code.getID());
            if(!isrepeartshoprecord) {
                userService.AddShoppingRecord(sr);
            }
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(isrepeartshoprecord);
        response.getWriter().print(s);
    }
}

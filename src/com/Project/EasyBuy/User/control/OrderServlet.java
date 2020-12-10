package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.Order;
import com.Project.EasyBuy.User.Entry.OrderDetail;
import com.Project.EasyBuy.User.Entry.User;
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

@WebServlet("/order.az")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("order".equalsIgnoreCase(action)) {
            doOrder(request, response);
        }else if("orderdetail".equalsIgnoreCase(action)){
            doOrderDetail(request, response);
        }
    }
    public void doOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<Order> orders = null;
        if(user!=null) {
            orders = userService.selectallOrder(user.getId().intValue());
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(orders);
        response.getWriter().print(s);
    }
    public void doOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String orderid = request.getParameter("orderid");
        ArrayList<OrderDetail> orderDetails = userService.selectallOrderDetail(Integer.parseInt(orderid));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(orderDetails);
        response.getWriter().print(s);
    }
}
package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.User;
import com.Project.EasyBuy.User.Service.IUserService;
import com.Project.EasyBuy.User.Service.impl.UserService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register1")
public class register1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if("regist1".equalsIgnoreCase(action)){
            domobile(request,response);
            return;
        }else if("register2".equalsIgnoreCase(action)){
            dore2(request,response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }
    public void domobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        IUserDao userdao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userdao);
        Boolean aBoolean = userService.isrepeatMobile(phone);
        Gson gson = new Gson();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void dore2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        HttpSession session = request.getSession();
        session.setAttribute("mobile",phone);
        response.sendRedirect("regist2.jsp");
    }
}

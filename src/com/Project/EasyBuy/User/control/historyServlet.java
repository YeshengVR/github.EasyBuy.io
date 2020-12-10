package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.BrowsingHistory;
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

@WebServlet("/history.z")
public class historyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if("gethistory".equalsIgnoreCase(action)){
            gethistory(request, response);
        }else if("deleteallhist".equalsIgnoreCase(action)){
            dodeletehist(request, response);
        }
    }
    public void gethistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        ArrayList<BrowsingHistory> browsingHistories = null;
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        if(userid==""){

        }else{
            browsingHistories = userService.selectBHistory(Integer.parseInt(userid));
        }
        Gson gson = new Gson();
        String s = gson.toJson(browsingHistories);
        response.getWriter().print(s);
    }
    public void dodeletehist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Boolean deletehistory =false;
        if(user!=null) {
            deletehistory = userService.deletehistory(user.getId());
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(deletehistory);
        response.getWriter().print(s);
    }
}

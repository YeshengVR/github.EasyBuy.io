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

@WebServlet("/register2")
public class register2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if("dousername".equalsIgnoreCase(action)){
            dousername(request,response);
            return;
        }else if("doemail".equalsIgnoreCase(action)){
            doemail(request,response);
            return;
        }else if("doIdent".equalsIgnoreCase(action)){
            doIdent(request,response);
            return;
        }else if("submit".equalsIgnoreCase(action)){
            dosubmit(request,response);
            return;
        }

    }
    public void dousername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        IUserDao userdao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userdao);
        Boolean aBoolean = userService.isrepeatUsername(username);
        Gson gson = new Gson();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void doemail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meail = request.getParameter("meail");
        IUserDao userdao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userdao);
        Boolean aBoolean = userService.isrepeatEmail(meail);
        Gson gson = new Gson();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void doIdent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identitycode = request.getParameter("identitycode");
        IUserDao userdao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userdao);
        Boolean aBoolean = userService.isrepeatIdentitycode(identitycode);
        Gson gson = new Gson();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void dosubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String mobile = request.getParameter("mobile");
        String loginname = request.getParameter("loginname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Number sex = Integer.parseInt(request.getParameter("sex"));
        String meail = request.getParameter("meail");
        String phone = request.getParameter("phone");
        String identitycode = request.getParameter("identitycode");
        User user = new User(null,loginname,username,password,sex,identitycode,meail,mobile,null,phone);
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        User register = userService.register(user);

        session.setAttribute("user",register);
        response.sendRedirect("index.jsp");
    }
}
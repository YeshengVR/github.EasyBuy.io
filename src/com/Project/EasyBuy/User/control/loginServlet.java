package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.User;
import com.Project.EasyBuy.User.Service.IUserService;
import com.Project.EasyBuy.User.Service.impl.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if("login".equalsIgnoreCase(action)){
            dologin(request,response);
            return;
        }else if("loginbefore".equalsIgnoreCase(action)){
            dologinbefore(request,response);
            return;
        }else if("layout".equalsIgnoreCase(action)){
            doLayout(request,response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }
    public void dologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ifAuto = request.getParameter("ifAuto");
        if("1".equalsIgnoreCase(ifAuto)){
            Cookie cookie1=new Cookie("username", URLEncoder.encode(username,"UTF-8"));
            cookie1.setMaxAge(7*24*60*60);
            response.addCookie(cookie1);
            Cookie cookie2=new Cookie("password", URLEncoder.encode(password,"UTF-8"));
            cookie2.setMaxAge(7*24*60*60);
            response.addCookie(cookie2);
        }else{
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if("username".equalsIgnoreCase(cookie.getName())){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if("password".equalsIgnoreCase(cookie.getName())){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        IUserDao userDao = UserDao.getInstance();
        HttpSession session = request.getSession();
        IUserService userService = UserService.getInstance(userDao);
        User login = userService.login(username, password);
//        HashMap<String,Object> map = new HashMap<String,Object>();
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if(login==null){
            response.sendRedirect("loadpage.jsp");
            session.setAttribute("flag",true);
        }else{
            session.setAttribute("user",login);
            response.sendRedirect("index.jsp");
        }
    }
    public void dologinbefore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        response.getWriter().print(gson.toJson(user));
        response.sendRedirect("index.jsp");
    }
    public void doLayout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
//        response.setHeader("Cache-Control","no-store");
//        response.setHeader("Pragma","no-cache");
//        response.setDateHeader("Expires",0);
        response.sendRedirect("loadpage.jsp");
    }
}

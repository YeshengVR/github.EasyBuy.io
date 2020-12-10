package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.*;
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

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if("news".equalsIgnoreCase(action)){
            donews(request,response);
            return;
        }else if("categorylv1".equalsIgnoreCase(action)){
            docategory1(request, response);
            return;
        }else if("categorylv2".equalsIgnoreCase(action)){
            docategory2(request, response);
            return;
        }else if("categorylv3".equalsIgnoreCase(action)){
            docategory3(request, response);
            return;
        }else if("ty".equalsIgnoreCase(action)){
            doty(request,response);
            return;
        }else if("sums".equalsIgnoreCase(action)){
            sum(request, response);
            return;
        }else if("doty2".equalsIgnoreCase(action)){
            doty2(request, response);
            return;
        }else if("doty3".equalsIgnoreCase(action)){
            doty1(request, response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }
    public void donews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        ArrayList<News> news = userService.News();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(news);
        response.getWriter().print(s);
    }
    public void docategory1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        ArrayList<Category> categories = userService.Categorylv1();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(categories);
        response.getWriter().print(s);
    }
    public void docategory2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String category = request.getParameter("category");
        ArrayList<Category> categories = userService.Categorylv2(Integer.parseInt(category));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(categories);
        response.getWriter().print(s);
    }
    public void docategory3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String category = request.getParameter("category");
        ArrayList<Category> categories = userService.Categorylv3(Integer.parseInt(category));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(categories);
        response.getWriter().print(s);
    }
    public void doty(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String id = request.getParameter("carid");
        String cname = request.getParameter("cname");
        PageEntry<Product> pe = new PageEntry<Product>(1,0,20,0,new ArrayList<Product>());
        Category category = userService.CateByid(Integer.parseInt(id));
        if (category.getPARENTID() != null) {
            Category category1 = userService.CateByid(category.getPARENTID().intValue());
            if (category1.getPARENTID() != null) {
                pe = userService.selectPageProductBy3Lv(pe, Integer.parseInt(id));
            } else {
                pe = userService.selectPageProductBy2Lv(pe, Integer.parseInt(id));
            }
        }else{
            pe = userService.selectPageProductBy1Lv(pe, Integer.parseInt(id));
        }
        HttpSession session = request.getSession();
        session.removeAttribute("catelist");
        session.removeAttribute("canme");
        session.removeAttribute("carid");
        session.setAttribute("catelist",pe);
        session.setAttribute("cname",cname);
        session.setAttribute("carid",id);
        session.removeAttribute("search");
        response.sendRedirect("CategoryList.jsp");
    }
    public void doty2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String id = request.getParameter("carid");
        String cname = request.getParameter("cname");
        PageEntry<Product> pe = new PageEntry<Product>(1,0,20,0,new ArrayList<Product>());
        pe = userService.selectPageProductBy2Lv(pe, Integer.parseInt(id));
        HttpSession session = request.getSession();
        session.removeAttribute("catelist");
        session.removeAttribute("canme");
        session.removeAttribute("carid");
        session.setAttribute("catelist",pe);
        session.setAttribute("cname",cname);
        session.setAttribute("carid",id);
        session.removeAttribute("search");
        response.sendRedirect("CategoryList.jsp");
    }
    public void doty1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String id = request.getParameter("carid");
        String cname = request.getParameter("cname");
        PageEntry<Product> pe = new PageEntry<Product>(1,0,20,0,new ArrayList<Product>());
        pe = userService.selectPageProductBy1Lv(pe, Integer.parseInt(id));
        HttpSession session = request.getSession();
        session.removeAttribute("catelist");
        session.removeAttribute("canme");
        session.removeAttribute("carid");
        session.setAttribute("catelist",pe);
        session.setAttribute("cname",cname);
        session.setAttribute("carid",id);
        session.removeAttribute("search");
        response.sendRedirect("CategoryList.jsp");
    }
    public void sum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Integer sums = 0;
        ArrayList<ShoppingRecord> selectallshoprecord = null;
        if(user!=null) {
            selectallshoprecord = userService.selectallshoprecord(user == null ? null : user.getId().intValue());
            for (ShoppingRecord shoppingRecord : selectallshoprecord) {
                sums += (shoppingRecord.getAMOUNT().intValue() * shoppingRecord.getPRICE().intValue());
            }
        }
        Gson gson = new Gson();
        String s = gson.toJson(sums);
        response.getWriter().print(s);
    }
}

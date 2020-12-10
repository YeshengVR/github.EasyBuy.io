package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.Category;
import com.Project.EasyBuy.User.Entry.Favority;
import com.Project.EasyBuy.User.Entry.Product;
import com.Project.EasyBuy.User.Entry.User;
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

@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("showfavorite".equalsIgnoreCase(action)) {
            showFavorite(request, response);
            return;
        } else if ("deletefavorite".equalsIgnoreCase(action)) {
            deletefavoriter(request, response);
            return;
        } else if("deleteallfavorite".equalsIgnoreCase(action)){
            deleteallfavorite(request, response);
            return;
        } else if("addfavoriter".equalsIgnoreCase(action)){
            addFavorite(request, response);
            return;
        } else if("onefav".equalsIgnoreCase(action)){
            ondeFavorite(request, response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String productid = request.getParameter("productid");
        Boolean aBoolean = false;
        if(user!=null){
            Product product = userService.ProductByID("EASYBUY_PRODUCT", "ID", Integer.parseInt(productid));
            if(userService.oneFav(user.getId(),Integer.parseInt(productid))) {
                Favority fav = new Favority(null, product.getID(), product.getFILENAME(), product.getCCODE(), null, user.getId(), product.getPrice(), product.getDESCRIPTION());
                aBoolean = userService.addFay(fav);
            }
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }

    /**
     * p按段是否被收藏
     * @param request
     * @param response
     * @throws IOException
     */
    public void ondeFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Boolean aBoolean = true;
        if(user!=null){
            String productid = request.getParameter("productid");
            aBoolean = userService.oneFav(user.getId(), Integer.parseInt(productid));
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void showFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Product> products = new ArrayList<Product>();
        if(user!=null){
            ArrayList<Favority> favorities = userService.showFavority(user.getId());
            if(favorities!=null&&favorities.size()!=0){
                for (Favority favority : favorities) {
                    Product selectshoucangid = userService.selectshoucangid(favority);
                    products.add(selectshoucangid);
                }
            }
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(products);
        response.getWriter().print(s);
    }
    public void deletefavoriter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String productid = request.getParameter("productid");
        Boolean aBoolean = false;
        if(user!=null){
            aBoolean = userService.deleteFav(user.getId(),Integer.parseInt(productid));
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
    public void deleteallfavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Boolean aBoolean = false;
        if(user!=null){
            aBoolean = userService.deleteallFav(user.getId());
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(aBoolean);
        response.getWriter().print(s);
    }
}
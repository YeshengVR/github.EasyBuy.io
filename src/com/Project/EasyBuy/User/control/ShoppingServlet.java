package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.Category;
import com.Project.EasyBuy.User.Entry.Product;
import com.Project.EasyBuy.User.Entry.ShoppingRecord;
import com.Project.EasyBuy.User.Entry.User;
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

@WebServlet("/ShoppingServlet.zz")
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if("shoprecord".equalsIgnoreCase(action)){
            doShoppingrecord(request,response);
        }else if("selectname".equalsIgnoreCase(action)){
            doproductname(request,response);
        }
    }

    public void doShoppingrecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String userid = request.getParameter("user");
        if(userid==null||"null".equalsIgnoreCase(userid)||"".equalsIgnoreCase(userid)){
            return;
        }
        String currentpage = request.getParameter("currentpage");
        PageEntry<ShoppingRecord> pe = new PageEntry<ShoppingRecord>(Integer.parseInt(currentpage),0,3,0,new ArrayList<ShoppingRecord>());
        PageEntry<ShoppingRecord> shoppingRecordPageEntry = userService.selectPageShop(pe, Integer.parseInt(userid));
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(shoppingRecordPageEntry);
        response.getWriter().print(s);
    }
    public void doproductname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance(userDao);
        String id = request.getParameter("id");
        Product product = userService.ProductByID("EASYBUY_PRODUCT", "ID", Integer.parseInt(id));
        String description = product.getDESCRIPTION();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(description);
        response.getWriter().print(s);
    }


}
package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Dao.IUserDao;
import com.Project.EasyBuy.User.Dao.impl.UserDao;
import com.Project.EasyBuy.User.Entry.BrowsingHistory;
import com.Project.EasyBuy.User.Entry.Category;
import com.Project.EasyBuy.User.Entry.Product;
import com.Project.EasyBuy.User.Entry.User;
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

@WebServlet("/catelist")
public class Catelist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String action = request.getParameter("action");
        if ("search".equalsIgnoreCase(action)) {
            docategorylist(request, response);
            return;
        } else if ("page".equalsIgnoreCase(action)) {
            page(request, response);
            return;
        } else if ("pagetiao".equalsIgnoreCase(action)) {
            productdetail(request, response);
            return;
        } else if ("table".equalsIgnoreCase(action)) {
            tableajax(request, response);
            return;
        } else if ("table2".equalsIgnoreCase(action)) {
            tableajax2(request, response);
            return;
        } else if ("table3".equalsIgnoreCase(action)) {
            tableajax3(request, response);
            return;
        } else if ("price".equalsIgnoreCase(action)) {
            doprice(request, response);
            return;
        } else if("doSales".equalsIgnoreCase(action)){
            doSales(request, response);
            return;
        } else if("docreate".equalsIgnoreCase(action)){
            docreate(request, response);
            return;
        }
        response.sendRedirect("loadpage.jsp");
        return;
    }

    public void docategorylist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        HttpSession session = request.getSession();
//        String search = (String) session.getAttribute("search");
        String search = request.getParameter("search");
        Boolean flag = true;
        if (currentpage == null) {
            currentpage = "1";
        }
        if (search == "") {
            search = null;
        }
        session.removeAttribute("cname");
        session.setAttribute("search", search);
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        pe = userService.PageProduct(pe, search, "CREATEDATE", flag);
        session.setAttribute("catelist", pe);
        response.sendRedirect("CategoryList.jsp");
    }

    public void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        String search = request.getParameter("search");
        HttpSession session = request.getSession();
        session.setAttribute("search", search);
        String flag = request.getParameter("flag");
        if (currentpage == null||"0".equalsIgnoreCase(currentpage)) {
            currentpage = "1";
        }
//        String search = (String) session.getAttribute("search");
        if (search == "") {
            search = null;
        }
        session.removeAttribute("catelist");
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        pe = userService.PageProduct(pe, search, "CREATEDATE", flag.equalsIgnoreCase("true") ? true : false);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s = gson.toJson(pe);
        response.getWriter().print(s);
    }

    public void productdetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String id = request.getParameter("idd");
        Product product = userService.ProductByID("EASYBUY_PRODUCT", "ID", Integer.parseInt(id));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            BrowsingHistory bh = new BrowsingHistory(null, product.getFILENAME(), product.getID(), product.getNAME(), product.getDESCRIPTION(), product.getPrice(), null, user == null ? null : user.getId());
            userService.addhistor(bh);
        }
        session.removeAttribute("cname");
        session.setAttribute("product", product);
//        session.setAttribute("catelist",pe);
        response.sendRedirect("Product.jsp");
    }

    public void tableajax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String carid = (String) session.getAttribute("carid");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (carid == null) {
            String s = gson.toJson(false);
            response.getWriter().print(s);
            return;
        }
        Category category = userService.CateByid(Integer.parseInt(carid));
        ArrayList<Category> cates = null;
        Category category1 = null;
        if (category.getPARENTID() != null) {
            category1 = userService.CateByid(category.getPARENTID().intValue());
            if (category1.getPARENTID() != null) {
                cates = userService.selectType1(category1.getPARENTID().intValue());
            } else {
                cates = userService.selectType1(category1.getID().intValue());
            }
        }else{
            cates = userService.selectType1(category.getID().intValue());
        }
        String s = gson.toJson(cates);
        response.getWriter().print(s);
    }
    public void tableajax2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String carid = (String) session.getAttribute("carid");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (carid == null) {
            String s = gson.toJson(false);
            response.getWriter().print(s);
            return;
        }
        Category category = userService.CateByid(Integer.parseInt(carid));
        ArrayList<Category> cates = null;
        Category category1 = null;
        if (category.getPARENTID() != null) {
            category1 = userService.CateByid(category.getPARENTID().intValue());
            if (category1.getPARENTID() != null) {
                cates = userService.selectType2(category1.getPARENTID().intValue());
            } else {
                cates = userService.selectType2(category1.getID().intValue());
            }
        }else{
            cates = userService.selectType2(category.getID().intValue());
        }
        String s = gson.toJson(cates);
        response.getWriter().print(s);
    }
    public void tableajax3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        HttpSession session = request.getSession();
        String carid = (String) session.getAttribute("carid");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (carid == null) {
            String s = gson.toJson(false);
            response.getWriter().print(s);
            return;
        }
        Category category = userService.CateByid(Integer.parseInt(carid));
        ArrayList<Category> categories= null;
        Category category1 = null;
        if (category.getPARENTID() != null) {
            category1 = userService.CateByid(category.getPARENTID().intValue());
            if (category1.getPARENTID() != null) {
                categories = userService.Categorylv3(category.getPARENTID());
            } else{
                categories = userService.Categorylv2(category1.getID());
            }
        }else{
            categories = userService.Categorylv1();
        }
//        categories = userService.Categorylv3(category.getPARENTID());
        String s = gson.toJson(categories);
        response.getWriter().print(s);
    }

    public void doprice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        HttpSession session = request.getSession();
        String mixPrice = request.getParameter("mixPrice");
        String maxPrice = request.getParameter("maxPrice");
        String search = request.getParameter("search");
        String flag = request.getParameter("flag");
        session.setAttribute("search", search);
        if (currentpage == null) {
            currentpage = "1";
        }
        if (search == "") {
            search = null;
        }
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        String order = request.getParameter("order");
        if ("1".equalsIgnoreCase(order)) {
            pe = userService.selePageProductByPrice(pe, Product.class, mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice), search, "asc", flag.equalsIgnoreCase("true") ? true : false);
        } else {
            pe = userService.selePageProductByPrice(pe, Product.class, mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice), search, "desc", flag.equalsIgnoreCase("true") ? true : false);
        }
        Gson gson = new Gson();
        String s = gson.toJson(pe);
        response.getWriter().print(s);
    }
    public void docreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        HttpSession session = request.getSession();
        String search = request.getParameter("search");
        String flag = request.getParameter("flag");
        session.setAttribute("search", search);
        if (currentpage == null) {
            currentpage = "1";
        }
        if (search == "") {
            search = null;
        }
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        String order = request.getParameter("order");
        if ("1".equalsIgnoreCase(order)) {
            pe = userService.selectPageProductBycreatetime(pe,search,flag.equalsIgnoreCase("true") ? true : false," asc");
        } else {
            pe = userService.selectPageProductBycreatetime(pe,search,flag.equalsIgnoreCase("true") ? true : false," desc");
        }
        Gson gson = new Gson();
        String s = gson.toJson(pe);
        response.getWriter().print(s);
    }
    public void doSales(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        HttpSession session = request.getSession();
        String search = request.getParameter("search");
        String flag = request.getParameter("flag");
        session.setAttribute("search", search);
        if (currentpage == null) {
            currentpage = "1";
        }
        if (search == "") {
            search = null;
        }
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        String order = request.getParameter("order");
        if ("1".equalsIgnoreCase(order)) {
            pe = userService.selectPageProductBySales(pe,search,flag.equalsIgnoreCase("true") ? true : false," asc");
        } else {
            pe = userService.selectPageProductBySales(pe,search,flag.equalsIgnoreCase("true") ? true : false," desc");
        }
        Gson gson = new Gson();
        String s = gson.toJson(pe);
        response.getWriter().print(s);
    }

    /**
     * 通过的查找商品方法
     * @param request
     * @param response
     * @throws IOException
     */
    public void doproduct(HttpServletRequest request, HttpServletResponse response) throws IOException{
        IUserDao userDao = UserDao.getInstance();
        IUserService userService = UserService.getInstance(userDao);
        String currentpage = request.getParameter("currentpagecate");
        HttpSession session = request.getSession();
        String mixPrice = request.getParameter("mixPrice");
        String maxPrice = request.getParameter("maxPrice");
        String search = request.getParameter("search");
        String flag = request.getParameter("flag");
        String sort = request.getParameter("sort");
        session.setAttribute("search", search);
        PageEntry<Product> pe = new PageEntry<Product>(Integer.parseInt(currentpage), 0, 20, 0, new ArrayList<Product>());
        String order = request.getParameter("order");
        if (currentpage == null) {
            currentpage = "1";
        }
        if (search == "") {
            search = null;
        }
        if(flag.equalsIgnoreCase("true")?true:false){
            Category category = userService.sCateByname(search);
            if (category.getPARENTID() != null) {
                Category category1 = userService.CateByid(category.getPARENTID().intValue());
                if (category1.getPARENTID() != null) {
                    if ("1".equalsIgnoreCase(order)) {
                        pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," asc",flag.equalsIgnoreCase("true") ? true : false);
                    } else {
                        pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," desc",flag.equalsIgnoreCase("true") ? true : false);
                    }
                } else{
                    if ("1".equalsIgnoreCase(order)) {
                        pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," asc",flag.equalsIgnoreCase("true") ? true : false);
                    } else {
                        pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," desc",flag.equalsIgnoreCase("true") ? true : false);
                    }
                }
            }else{
                if ("1".equalsIgnoreCase(order)) {
                    pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," asc",flag.equalsIgnoreCase("true") ? true : false);
                } else {
                    pe = userService.selectPageProduct(pe,mixPrice == null ? null : Integer.parseInt(mixPrice), maxPrice == null ? null : Integer.parseInt(maxPrice),search,sort," desc",flag.equalsIgnoreCase("true") ? true : false);
                }
            }
        }
        Gson gson = new Gson();
        String s = gson.toJson(pe);
        response.getWriter().print(s);
    }
}

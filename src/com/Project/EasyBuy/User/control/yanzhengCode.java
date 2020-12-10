package com.Project.EasyBuy.User.control;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authcode")
public class yanzhengCode extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String clientCheckcode = request.getParameter("validateCode");//接收客户端浏览器提交上来的验证码
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
        Gson gson = new Gson();
        String s;
        if (serverCheckcode.equalsIgnoreCase(clientCheckcode)) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
            s = gson.toJson(true);
            response.getWriter().print(gson.toJson(s));
        } else {
            s = gson.toJson(false);
            response.getWriter().print(gson.toJson(s));
        }
        return;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

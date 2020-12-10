package com.Project.EasyBuy.User.control;

import com.Project.EasyBuy.User.Entry.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class filter implements Filter {
    private static String excludedPaths;
    private static String[] excludedPathArray;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPaths = filterConfig.getInitParameter("excludedPaths");
        if(!isEmpty(excludedPaths)) {
            excludedPathArray = excludedPaths.split(",");
        }
    }
    private static Boolean isEmpty(String str){
        if(str!=""&&str!=null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        // 判断是否是直接放行的请求
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String mobile = (String)session.getAttribute("mobile");

//        session.setAttribute("aaaaaa","AAAAAAAAA");

        if (!isFilterExcludeRequest(request)) {
            // TODO 这里写你的过滤器处理逻辑
            if(user!=null){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }else{
                if(mobile!=null){
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }else{
                    request.getRequestDispatcher("loadpage.jsp").forward(servletRequest, servletResponse);
                    return;
                }
            }
        }
        //放行的方法
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是否是 过滤器直接放行的请求
     * 主要用于静态资源的放行
     * @return
     */
    private boolean isFilterExcludeRequest(HttpServletRequest request) {
        if(null != excludedPathArray && excludedPathArray.length > 0) {
            String url = request.getRequestURI();
            for (String ecludedUrl : excludedPathArray) {
                if (ecludedUrl.startsWith("*.")) {
                    // 如果配置的是后缀匹配, 则把前面的*号干掉，然后用endWith来判断
                    if(url.endsWith(ecludedUrl.substring(1))){
                        return true;
                    }
                } else if (ecludedUrl.endsWith("/*")) {
                    if(!ecludedUrl.startsWith("/")) {
                        // 前缀匹配，必须要是/开头
                        ecludedUrl = "/" + ecludedUrl;
                    }
                    // 如果配置是前缀匹配, 则把最后的*号干掉，然后startWith来判断
                    String prffixStr = request.getContextPath() + ecludedUrl.substring(0, ecludedUrl.length() - 1);
                    if(url.startsWith(prffixStr)) {
                        return true;
                    }
                } else {
                    // 如果不是前缀匹配也不是后缀匹配,那就是全路径匹配
                    if(!ecludedUrl.startsWith("/")) {
                        // 全路径匹配，也必须要是/开头
                        ecludedUrl = "/" + ecludedUrl;
                    }
                    String targetUrl = request.getContextPath() + ecludedUrl;
                    if(url.equals(targetUrl)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

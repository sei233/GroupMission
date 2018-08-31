package com.market.filter;

import com.market.bean.po.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        Login login = (Login) request.getSession().getAttribute("user");
        String url = request.getRequestURL().toString();
        System.out.println(url);
        if (login!=null){
            chain.doFilter(req, resp);
            return;
        }
        if (login==null && (url.endsWith("LoginController") || url.endsWith("8080/") || url.endsWith("login.jsp"))){
            chain.doFilter(req, resp);
            return;
        }
        if (login==null){
            request.setAttribute("msg", "noLogin");
            request.getRequestDispatcher("login.jsp").forward(request, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

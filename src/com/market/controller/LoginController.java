package com.market.controller;


import com.market.bean.po.Login;
import com.market.service.Impl.LogService;
import com.market.service.Impl.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.System;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "LoginController",urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String type = request.getParameter("type");
            LoginService ls = new LoginService();
            LogService logs = new LogService();
            if (type == null) {
                type = "";
            }
            switch (type) {
                case "update": {

                    request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
                    break;
                }
                case "updateToUser": {
                    String account = request.getParameter("userAccount");
                    String oldpassword = request.getParameter("oldpassword");
                    String newpassword = request.getParameter("newpassword");
                    ArrayList<Login> login_list = (ArrayList<Login>) new LoginService().findObj();
                    for (Login l : login_list) {
                        if (l.getUserAccount().equals(account) && l.getUserPassword().equals(oldpassword) && !l.getUserPassword().equals(newpassword)) {
                            Pattern p = Pattern.compile("^[A-Za-z0-9]{8,}$");
                            Matcher m = p.matcher(newpassword);
                            if (m.find()) {
                                int row = ls.changeObj(newpassword, account);
                                if (row == 1) {
                                    request.setAttribute("msg", "updatesucc");
                                    request.getRequestDispatcher("login.jsp").forward(request, response);
                                    java.sql.Timestamp timenow = new Timestamp(System.currentTimeMillis());
                                    logs.addObj(account, "修改密码", timenow);
                                }
                            }
                            request.setAttribute("msg", "passwordillegal");
                            request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
                        }
                    }
                    request.setAttribute("msg", "updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);;
                    break;


                }
                case "logout": {
                    HttpSession session  = request.getSession(false);
                    System.out.println(request.getContextPath());
                    if(session==null){
                        response.sendRedirect("login.jsp");
                        return;
                    }
                    session.removeAttribute("loginName");
                    response.sendRedirect("login.jsp");
                    return;
                }
                case "login": {
                    String account = request.getParameter("userAccount");
                    String password = request.getParameter("userPassword");
                    ArrayList<Login> login_list = (ArrayList<Login>) new LoginService().findObj();
                        for (Login l : login_list) {
                            if (l.getUserAccount().equals(account) && l.getUserPassword().equals(password)) {
                                //把用户数据保存在session域对象中
                                request.getSession().setAttribute("loginName", account);
                                java.sql.Timestamp timenow = new Timestamp(System.currentTimeMillis());
                                logs.addObj(account, "登录", timenow);
                                request.getRequestDispatcher("index.html").forward(request, response);
                                return;
                            }
                        }
                        request.setAttribute("msg", "loginfail");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        break;
                    }

                }
            }

            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
    }






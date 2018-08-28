package com.market.controller;


import com.market.bean.po.Login;
import com.market.service.Impl.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController",urlPatterns = "/LoginController")

    public class LoginController extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String type = request.getParameter("type");
            LoginService ls = new LoginService();
            if (type == null) {
                type = "";
            }
            switch (type) {
                case "update": {
                    String account = request.getParameter("userAccount");
                    Login login= (Login) ls.findObjById(Integer.valueOf(account));
                    request.setAttribute("login", login);
                    request.getRequestDispatcher("/WEB-INF/jsp/password_update.jsp").forward(request, response);
                    break;
                }
                case "updateToUser": {
                    String account = request.getParameter("userAccount");
                    String password = request.getParameter("userPassword");
                    int row = ls.changeObj(account,password);
                    if (row==1){
                        request.setAttribute("msg","updatesucc");
                        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
                    }else {
                        request.setAttribute("msg","updatefail");
                        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
                    }
                    break;
                }
                case "login": {
                    String account = request.getParameter("userAccount");
                    String password = request.getParameter("userPassword");
                    Login login = new Login();
                    login.setUserAccount(account);
                    login.setUserPassword(password);

                    //把注册成功的用户对象保存在session对象中
                    request.getSession().setAttribute("Login", login);

                    //判断用户名是否合法
                    if (login.getUserAccount().equals(account) && login.getUserPassword().equals(password)) {
                        request.setAttribute("msg", "loginsucc");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "loginfail");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request, response);
                    }


                }
            }
        }






        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
    }






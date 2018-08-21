package com.market.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ApplicationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        System.out.print(type);
        if("add".equals(type)){

        }
        if("query".equals(type)){

        }
        if("delete".equals(type)){

        }
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(req, resp);
    }
}

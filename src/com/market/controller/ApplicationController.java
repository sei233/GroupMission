package com.market.controller;

import com.market.bean.Application;
import com.market.service.ApplicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ApplicationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String page = req.getParameter("page");

        if("add".equals(type)){

        }
        if("query".equals(type)){

        }
        if("delete".equals(type)){

        }

        if(page==null){
            page="1";
        }

        //分页
        ApplicationService applicationService = new ApplicationService();
        List<Application> applications = applicationService.selectByPage(Integer.parseInt(page), 3);
        req.setAttribute("apps",applications);

        //重定向
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(req, resp);
    }
}

package com.market.controller;

import com.market.bean.po.Application;
import com.market.bean.vo.ApplicationVo;
import com.market.service.Impl.ApplicationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ApplicationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationService applicationService = new ApplicationService();
        List<Application> applications = new ArrayList<>();
        String type = req.getParameter("type");
        String page = req.getParameter("page");

        if ("add".equals(type)) {

        } else if ("query".equals(type)) {
            String antiOutID = req.getParameter("antiOutID");
            String outSign = req.getParameter("outSign");
            String approvalState = req.getParameter("approvalState");
            String docuMaker = req.getParameter("docuMaker");
            String docuTimeBegin = req.getParameter("docuTimeBegin");
            String docuTimeEnd = req.getParameter("docuTimeEnd");
            String approvalTimeBegin = req.getParameter("approvalTimeBegin");
            String approvalTimeEnd = req.getParameter("approvalTimeEnd");
            applications=applicationService.findObj(antiOutID, outSign, approvalState, docuMaker, docuTimeBegin, docuTimeEnd, approvalTimeBegin, approvalTimeEnd);

        } else if ("delete".equals(type)) {
            String id = req.getParameter("id");
        } else {
            if (page == null) {
                page = "1";
            }

            //分页
            applications = applicationService.selectByPage(Integer.parseInt(page), 3);
        }


        //统一封装
        Iterator iter = applications.iterator();
        List<ApplicationVo> appVoList = new ArrayList<>();

        while (iter.hasNext()) {
            Application app = (Application) iter.next();
            ApplicationVo appVo = new ApplicationVo();
            appVo.setApp(app);
            appVoList.add(appVo);

        }
        req.setAttribute("appVos", appVoList);

        //重定向
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/app_out.jsp");
        dispatcher.forward(req, resp);

    }
}

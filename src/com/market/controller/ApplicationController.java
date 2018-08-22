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
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationService applicationService = new ApplicationService();
        String type = req.getParameter("type");
        String page = req.getParameter("page");

        if("add".equals(type)){

        }
        else if("query".equals(type)){
            String appID = req.getParameter("appID");
            System.out.print("返厂出库单号"+appID);

            String outSign = req.getParameter("outSign");
            System.out.print("返厂出库标志"+outSign);

            String approvalState = req.getParameter("approvalState");
            System.out.print("审核状态"+approvalState);

            String docuMaker = req.getParameter("docuMaker");
            System.out.print("制单人"+docuMaker);

            String docuTime = req.getParameter("docuTime");
            System.out.print("制单时间"+docuTime);

            String approvalTime = req.getParameter("approvalTime");
            System.out.print("审批时间"+approvalTime);
        }
        else if("delete".equals(type)){
            String id = req.getParameter("id");
            applicationService.deleteById(Integer.parseInt(id));
        }

        if(page==null){
            page="1";
        }

        //分页
        List<Application> applications = applicationService.selectByPage(Integer.parseInt(page), 3);
        Iterator iter = applications.iterator();
        List<ApplicationVo> appVoList = new ArrayList<>();

        while(iter.hasNext()){
            Application app = (Application)iter.next();
            ApplicationVo appVo = new ApplicationVo();
            appVo.setApp(app);
            appVoList.add(appVo);
        }

        req.setAttribute("appVos",appVoList);

        //重定向
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/app_out.jsp");
        dispatcher.forward(req, resp);
    }
}

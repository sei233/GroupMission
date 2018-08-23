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
    private ApplicationService applicationService = new ApplicationService();
    private List<Application> applications = new ArrayList<>();
    private List<ApplicationVo> appVoList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String type = req.getParameter("type");
        String page = req.getParameter("page");

        if ("addRe".equals(type)) {
            addRe(req,resp);
        } else if ("query".equals(type)) {                                                                     //查询
            query(req, resp);
        } else if ("delete".equals(type)) {                                                                     //删除
            delete(req,resp,page);
        } else {                                                                                        //首页
            show(page);
            //封装
            appVoList = pack();
            req.setAttribute("appVos", appVoList);
            //转发
            dispatcher(req, resp);
        }
    }

    private void addRe(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有的商品信息

        //把所有商品封装到request域里

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/app_add.jsp");
        dispatcher.forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp,String page) throws ServletException, IOException {
        String[] appIDs = req.getParameterValues("appID");
        if(appIDs!=null) {
            for (int i = 0; i < appIDs.length; i++) {
                applicationService.deleteObj(Integer.parseInt(appIDs[i]));
            }
        }
        show(page);

        //封装
        appVoList = pack();
        req.setAttribute("appVos", appVoList);

        //重定向
        resp.sendRedirect("/app_out");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String antiOutID = req.getParameter("antiOutID");
        String outSign = req.getParameter("outSign");
        String approvalState = req.getParameter("approvalState");
        String docuMaker = req.getParameter("docuMaker");
        String docuTimeBegin = req.getParameter("docuTimeBegin");
        String docuTimeEnd = req.getParameter("docuTimeEnd");
        String approvalTimeBegin = req.getParameter("approvalTimeBegin");
        String approvalTimeEnd = req.getParameter("approvalTimeEnd");
        applications=applicationService.findObj(antiOutID, outSign, approvalState, docuMaker, docuTimeBegin, docuTimeEnd, approvalTimeBegin, approvalTimeEnd);

        //封装
        appVoList = pack();
        req.setAttribute("appVos", appVoList);

        dispatcher(req,resp);
    }

    private void show(String page){
        if (page == null) {
            page = "1";
        }
        //分页
        applications = applicationService.selectByPage(Integer.parseInt(page), 5);
    }

    //统一封装applications
    private List<ApplicationVo> pack(){
        Iterator iter = applications.iterator();
        List<ApplicationVo> appVoList = new ArrayList<>();

        while (iter.hasNext()) {
            Application app = (Application) iter.next();
            ApplicationVo appVo = new ApplicationVo();
            appVo.setApp(app);
            appVoList.add(appVo);

        }
        return appVoList;
    }

    private void dispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/app_out.jsp");
        dispatcher.forward(req, resp);
    }
}

package com.market.controller;

import com.market.bean.po.ActivityAPC;
import com.market.bean.po.Good;
import com.market.dao.Dao;
import com.market.service.Impl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
@WebServlet(name = "activityAPCController")
public class activityAPCController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        APCService as = new APCService();
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_add.jsp").forward(request,response);
                break;
            }
            case "selectGood":{
                response.sendRedirect("/good_out");
                break;
            }
            case "loadGood":{
                Integer goodId = Integer.parseInt(request.getParameter("id"));
                Good good = new Dao<Good>().loadObjextById(Good.class, SqlSmt.FINDID_GOOD,goodId);
                request.setAttribute("good",good);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_add.jsp").forward(request,response);
                break;
            }
            case "addToAPC":{
                //activityName,beginTime,endTime,goodId,goodName,goodPrice,activityNumber,priceRange,activityPrice,reason,remarks
                String activityName = request.getParameter("activityName");
                String beginTime =  request.getParameter("beginTime");
                String endTime = request.getParameter("endTime");
                String goodId = request.getParameter("goodId");
                String goodName = request.getParameter("goodName");
                String goodPrice = request.getParameter("goodPrice");
                String activityNumber = request.getParameter("activityNumber");
                String priceRange = request.getParameter("priceRange");
                Float activityPrice = Float.parseFloat(goodPrice)*Float.parseFloat(priceRange)/100;
                String reason = request.getParameter("reason");
                String remarks = request.getParameter("remarks");
//                System.out.println(activityName+":"+beginTime+":"+endTime+":"+goodId+":"+goodName+":"+goodPrice+":"+activityNumber+":"+priceRange+":"+activityPrice+":"+reason+":"+remarks);
                int row = as.addObj(activityName,beginTime,endTime,goodId,goodName,goodPrice,activityNumber,priceRange,activityPrice,reason,remarks);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加活动"+activityName+"申请",timenow);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                }
                break;
            }
            case "delete":{
                String id = request.getParameter("id");
                int row = as.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除活动"+id+"申请",timenow);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                }
                break;
            }
            //修改选中商品
            case "update":{
                String id = request.getParameter("id");
                ActivityAPC activity = as.findObjById(Integer.parseInt(id));
                request.setAttribute("activity",activity);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_update.jsp").forward(request,response);
                break;
            }
            case "updateThis":{
                //activityName=?,beginTime=?,endTime=?,priceRange=?,reason=?,remarks=?,activityNumber=?,activityPrice=?
                String activityName = request.getParameter("activityName");
                String beginTime = request.getParameter("beginTime");
                String endTime = request.getParameter("endTime");
                String priceRange = request.getParameter("priceRange");
                String reason = request.getParameter("reason");
                String remarks = request.getParameter("remarks");
                String activityNumber = request.getParameter("activityNumber");
                String goodPrice = request.getParameter("goodPrice");
                Float activityPrice=Float.parseFloat(goodPrice)*Float.parseFloat(priceRange)/100;
                String activityId = request.getParameter("activityId");
                int row = as.changeObj(activityName,beginTime,endTime,priceRange,reason,remarks,activityNumber,activityPrice,activityId);
                if (row==1){
                    request.setAttribute("msg","updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"修改活动"+activityName+"申请",timenow);
                }else {
                    request.setAttribute("msg","updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                }
                break;
            }
            case "find":{
                String id = request.getParameter("id");
                ArrayList<ActivityAPC> activity_list = (ArrayList<ActivityAPC> )as.findObjByMultiCondition(id);
                try{
                    ActivityAPC activity = as.findObjById(Integer.parseInt(id));
                    if (activity!=null)
                        activity_list.add(activity);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
                    if (activity_list.size()>0) {
                        request.setAttribute("activity_list", activity_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request, response);
                        java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                        logs.addObj(loginName,"查询活动"+id+"申请",timenow);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request, response);
                    }
                }
                break;
            }
            //查看商品
            case "show":{
                //跳转到商品详情页,findID
                String id = request.getParameter("id");
                ActivityAPC activity = as.findObjById(Integer.parseInt(id));
                request.setAttribute("activity",activity);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_detail.jsp").forward(request,response);
                java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                logs.addObj(loginName,"查看活动"+id+"申请详情",timenow);
                break;
            }
            //默认操作，返回原页
            default:
                ArrayList<ActivityAPC> activity_list = (ArrayList<ActivityAPC>)as.findObj();
                request.setAttribute("activity_list",activity_list);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPC_out.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

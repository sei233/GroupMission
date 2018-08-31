package com.market.controller;

import com.market.bean.po.ActivityAPC;
import com.market.service.Impl.APCService;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "activityAPVController")
public class activityAPVController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("type/text;charset=UTF-8");
        String type = request.getParameter("type");
        APCService as = new APCService();
        if (type==null){
            type="";
        }
        switch (type){
            case "ajax":{
                String state = request.getParameter("state");
                ArrayList<ActivityAPC> activity_list = null;
                if (state.equals("5")){
                    activity_list=(ArrayList<ActivityAPC>)as.findObj();
                }else {
                    activity_list= as.findByState(Integer.parseInt(state));
                }
                Gson gson = new Gson();
                String json = gson.toJson(activity_list);
                System.out.println(json);
                response.getWriter().write(json);

                break;
            }
            case "apv":{
                String id = request.getParameter("id");
                ActivityAPC activity = as.findObjById(Integer.parseInt(id));
                request.setAttribute("activity",activity);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_apv.jsp").forward(request,response);
                break;
            }
            case "yes":{
                String activityId = request.getParameter("activityId");
                String approveState = request.getParameter("approveState");
                String approveComment = request.getParameter("approveComment");
                Integer apvS;
                Date date = new Date();
                if (Integer.parseInt(approveState)<3){
                    apvS = Integer.parseInt(approveState)+1;
                    int row = as.apvUpdate(apvS,approveComment,date,activityId);
                    if (row == 1) {
                        request.setAttribute("msg", "apvyes");
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                    }else {
                        request.setAttribute("msg", "apvno");
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                    }

                }else {
                    request.setAttribute("msg", "apverr");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                }
                break;
            }
            case "no":{
                String activityId = request.getParameter("id");
                String approveComment = request.getParameter("approveComment");
                Date date = new Date();
                int row = as.apvUpdate(4,approveComment,date,activityId);
                if (row == 1) {
                    request.setAttribute("msg", "apvyes");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                }else {
                    request.setAttribute("msg", "apvno");
                    request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
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
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request, response);
                    }
                }
                break;
            }
            case "show":{
                String id = request.getParameter("id");
                ActivityAPC activity = as.findObjById(Integer.parseInt(id));
                request.setAttribute("activity",activity);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_detail.jsp").forward(request,response);
                break;
            }
            //默认操作，返回原页
            default:
                ArrayList<ActivityAPC> activity_list = (ArrayList<ActivityAPC>)as.findObj();
                request.setAttribute("activity_list",activity_list);
                request.getRequestDispatcher("/WEB-INF/jsp/activityAPV_out.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

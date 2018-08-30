package com.market.controller;

import com.market.service.Impl.LogService;
import com.market.bean.po.Log;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogController",urlPatterns = "/LogController")
public class LogController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type == null) {
            type = "";
        }
        switch (type) {
            case "delete": {
                String id = request.getParameter("id");
                int row = logs.deleteObj(Integer.parseInt(id));
                if (row == 1) {
                    request.setAttribute("msg", "deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除日志"+id,timenow);
                } else {
                    request.setAttribute("msg", "deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request, response);
                }
//                System.out.println(id);
                break;
            }
            case "find": {
                String id =request.getParameter("id");
                ArrayList<Log> log_list = (ArrayList<Log> )logs.findObjByMultiCondition(id);

                try{
                    Log log = logs.findObjById(Integer.parseInt(id));
                    if (log!=null)
                        log_list.add(log);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
                    request.setAttribute("log_list", log_list);
                    request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"查询日志"+id,timenow);
                }
                break;
            }
            default: {
                ArrayList<Log> log_list = (ArrayList<Log>) logs.findObj();
                request.setAttribute("log_list", log_list);
                request.getRequestDispatcher("/WEB-INF/jsp/log.jsp").forward(request, response);
                break;
            }
        }
            
            

    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

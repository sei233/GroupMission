package com.market.controller;

import com.market.bean.po.Type;
import com.market.service.Impl.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TypeController")
public class TypeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        TypeService ts = new TypeService();
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
                break;
            }
            case "delete":{
                String id = request.getParameter("id");
                int row = ts.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                }
                break;
            }
            default:{
                ArrayList<Type> type_list = (ArrayList<Type>)ts.findObj();
                request.setAttribute("type_list",type_list);
                request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                break;
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

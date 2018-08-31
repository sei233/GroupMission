package com.market.controller;

import com.market.bean.po.Type;
import com.market.service.Impl.LogService;
import com.market.service.Impl.TypeService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "TypeController")
public class TypeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        TypeService ts = new TypeService();
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
                request.getRequestDispatcher("/WEB-INF/jsp/type_add.jsp").forward(request,response);
                break;
            }
            case "addToType":{
                String typeName = request.getParameter("typeName");
                String typeDescribe = request.getParameter("typeDescribe");
                int row = ts.addObj(typeName,typeDescribe);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加商品类型"+typeName,timenow);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                }
            }
            case "find":{
                String id =request.getParameter("id");
                ArrayList<Type> type_list = (ArrayList<Type> )ts.findObjByMultiCondition(id);
                try{
                    Type type11 = ts.findObjById(Integer.parseInt(id));
                    if (type11!=null)
                        type_list.add(type11);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
//                    System.out.println(type_list.size());
                    if (type_list.size()>0) {
                        request.setAttribute("type_list", type_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request, response);
                        java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                        logs.addObj(loginName,"查询商品类型"+id,timenow);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request, response);
                    }
                }
                break;
            }
            case "delete":{
                String id = request.getParameter("id");
                int row = ts.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/type_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除商品类型"+id,timenow);
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

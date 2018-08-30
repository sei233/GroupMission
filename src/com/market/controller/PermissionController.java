package com.market.controller;

import com.market.bean.po.Permission;
import com.market.bean.po.Permission;
import com.market.dao.Dao;
import com.market.service.Impl.LogService;
import com.market.service.Impl.PermissionService;
import com.market.service.Impl.SqlSmt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "PermissionController",urlPatterns = "/PermissionController")
public class PermissionController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        PermissionService ps = new PermissionService();
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
//                request.setAttribute("permission_list",permission_list);
                request.getRequestDispatcher("/WEB-INF/jsp/permission_add.jsp").forward(request,response);
                break;
            }
            case "addToPermission" :{
                String permissionName=request.getParameter("permissionName");
                String permissionDesc=request.getParameter("permissionDesc");
                String permissionOps=request.getParameter("permissionOps");
                int row = ps.addObj(permissionName,permissionDesc,permissionOps);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加权限"+permissionName,timenow);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                }
                break;
            }

            case "delete":{
                String id = request.getParameter("id");
                int row = ps.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除权限"+id,timenow);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                }
//                System.out.println(id);
                break;
            }

            case "update":{
                String id = request.getParameter("id");
                Permission permission = ps.findObjById(Integer.parseInt(id));
                request.setAttribute("permission",permission);
                request.getRequestDispatcher("/WEB-INF/jsp/permission_update.jsp").forward(request,response);
                break;
            }
            case "updateToPermission":{
                String id = request.getParameter("permissionId");
                String name = request.getParameter("permissionName");
                String desc = request.getParameter("permissionDesc");
                String ops = request.getParameter("permissionOps");
                int row = ps.changeObj(name,desc,ops,id);
                if (row==1){
                    request.setAttribute("msg","updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"修改权限"+name,timenow);
                }else {
                    request.setAttribute("msg","updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                }
                break;
            }
            case "find":{
                String id =request.getParameter("id");
                ArrayList<Permission> permission_list = (ArrayList<Permission> )ps.findObjByMultiCondition(id);
                try{
                    Permission permission = ps.findObjById(Integer.parseInt(id));
                    if (permission!=null)
                        permission_list.add(permission);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
                    request.setAttribute("permission_list", permission_list);
                    request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"查询权限"+id,timenow);
                }
                break;
            }
            default:{
                ArrayList<Permission> permission_list = (ArrayList<Permission>)ps.findObj();
                request.setAttribute("permission_list",permission_list);
                request.getRequestDispatcher("/WEB-INF/jsp/permission_out.jsp").forward(request,response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

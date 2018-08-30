package com.market.controller;



import com.market.bean.po.Role;
import com.market.dao.Dao;

import com.market.service.Impl.LogService;
import com.market.service.Impl.RoleService;
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


@WebServlet(name = "RoleController",urlPatterns = "/RoleController")
public class RoleController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        RoleService rs = new RoleService();
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type == null) {
            type = "";
        }
        switch (type) {
            case "add": {

               // request.setAttribute("role_list", role_List);
                request.getRequestDispatcher("/WEB-INF/jsp/role_add.jsp").forward(request, response);
                break;
            }
            case "addToRole": {
                String roleName = request.getParameter("roleName");
                String roleDesc = request.getParameter("roleDesc");
                String roleStatus = request.getParameter("roleStatus");
                String roleDept = request.getParameter("roleDept");

                int row = rs.addObj(roleName, roleDesc, roleStatus, roleDept);
                if (row == 1) {
                    request.setAttribute("msg", "addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加角色"+roleName,timenow);
                } else {
                    request.setAttribute("msg", "addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                }
                break;
            }

            case "delete": {
                String id = request.getParameter("id");
                int row = rs.deleteObj(Integer.parseInt(id));
                if (row == 1) {
                    request.setAttribute("msg", "deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除角色"+id,timenow);
                } else {
                    request.setAttribute("msg", "deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                }
//                System.out.println(id);
                break;
            }

            case "update": {
                String id = request.getParameter("id");
                Role role = rs.findObjById(Integer.parseInt(id));
                request.setAttribute("role", role);
                request.getRequestDispatcher("/WEB-INF/jsp/role_update.jsp").forward(request, response);
                break;
            }
            case "updateToRole": {
                String id = request.getParameter("roleId");
                String name = request.getParameter("roleName");
                String desc = request.getParameter("roleDesc");
                String status = request.getParameter("roleStatus");
                String dept = request.getParameter("roleDept");

                int row = rs.changeObj(name, desc, status, dept, id);
                if (row == 1) {
                    request.setAttribute("msg", "updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"修改角色"+name,timenow);
                } else {
                    request.setAttribute("msg", "updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                }
                break;
            }
            case "find": {
                String id =request.getParameter("id");
                ArrayList<Role> role_list = (ArrayList<Role> )rs.findObjByMultiCondition(id);
                try{
                    Role role = rs.findObjById(Integer.parseInt(id));
                    if (role!=null)
                        role_list.add(role);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
                    request.setAttribute("role_list", role_list);
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"查询角色"+id+"信息",timenow);
                }
                break;
            }
            default: {
                ArrayList<Role> role_list = (ArrayList<Role>) rs.findObj();
                request.setAttribute("role_list", role_list);
                request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                break;
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}


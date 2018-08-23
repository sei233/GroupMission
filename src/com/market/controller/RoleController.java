package com.market.controller;


import com.market.bean.po.Role;
import com.market.dao.Dao;
import com.market.service.Impl.RoleService;
import com.market.service.Impl.SqlSmt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RoleController",urlPatterns = "/RoleController")
public class RoleController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        RoleService rs = new RoleService();
        if (type == null) {
            type = "";
        }
        switch (type) {
            case "add": {
//                request.setAttribute("role_list",role_list);
                request.getRequestDispatcher("/WEB-INF/jsp/role_add.jsp").forward(request, response);
                break;
            }
            case "addToRole": {
                String roleName = request.getParameter("roleName");
                String roleDesc = request.getParameter("roleDesc");
                Integer roleStatus = Integer.valueOf(request.getParameter("roleStatus"));
                int roleDept = Integer.parseInt(request.getParameter("roleDept"));

                int row = rs.addObj(roleName, roleDesc, roleStatus, roleDept);
                if (row == 1) {
                    request.setAttribute("msg", "addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
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
                Integer status = Integer.valueOf(request.getParameter("roleStatus"));
                int dept = Integer.parseInt(request.getParameter("roleDept"));

                int row = rs.changeObj(name, desc, status, dept, id);
                if (row == 1) {
                    request.setAttribute("msg", "updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                }
                break;
            }
            case "find": {
                String id = request.getParameter("id");
                if (id != null && id != "") {
                    StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_BRAND);
                    sb.append(" and roleName like \'%");
                    sb.append(id);
                    sb.append("%\'");
                    System.out.println(sb.toString());
                    ArrayList<Role> role_list = new Dao<Role>().loadAllObjects(Role.class, sb.toString());
                    try {
                        Role role = rs.findObjById(Integer.parseInt(id));
                        if (role != null)
                            role_list.add(role);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } finally {
                        request.setAttribute("role_list", role_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/role_out.jsp").forward(request, response);
                    }


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


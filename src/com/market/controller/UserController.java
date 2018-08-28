package com.market.controller;

import com.market.bean.po.User;

import com.market.dao.Dao;
import com.market.service.Impl.SqlSmt;
import com.market.service.Impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "UserController",urlPatterns = "/UserController")
    public class UserController extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String type = request.getParameter("type");
            UserService us = new UserService();
            if (type == null) {
                type = "";
            }
            switch (type){
                case "add":{
//                request.setAttribute("user_list",user_list);
                    request.getRequestDispatcher("/WEB-INF/jsp/user_add.jsp").forward(request,response);
                    break;
                }
                case "addToUser" :{
                    String userAccount=request.getParameter("userAccount");
                    String userName=request.getParameter("userName");
                    Integer userSex= Integer.valueOf(request.getParameter("userSex"));
                    int userDept= Integer.parseInt(request.getParameter("userDept"));
                    Integer userStatus= Integer.valueOf(request.getParameter("userStatus"));
                    Integer userTitle= Integer.valueOf(request.getParameter("userTitle"));
                    String userPhone=request.getParameter("userPhone");
                    String userEmail=request.getParameter("userEmail");
                    int userRole= Integer.parseInt(request.getParameter("userRole"));
                    String userRemark1=request.getParameter("userRemark1");
                    String userRemark2=request.getParameter("userRemark2");
                    String userRemark3=request.getParameter("userRemark3");
                    String userRemark4=request.getParameter("userRemark4");
                    String userRemark5=request.getParameter("userRemark5");
                    int row = us.addObj(userAccount,userName,userDept,userSex,userStatus,userTitle,userPhone,userEmail,userRole,userRemark1,userRemark2,userRemark3,userRemark4,userRemark5);
                    if (row==1){
                        request.setAttribute("msg","addsucc");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }else {
                        request.setAttribute("msg","addfail");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }
                    break;
                }

                case "delete":{
                    String id = request.getParameter("id");
                    int row = us.deleteObj(Integer.parseInt(id));
                    if (row==1){
                        request.setAttribute("msg","deletesucc");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }else {
                        request.setAttribute("msg","deletefail");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }
//                System.out.println(id);
                    break;
                }

                case "update":{
                    String id = request.getParameter("id");
                    User user = us.findObjById(Integer.parseInt(id));
                    request.setAttribute("user",user);
                    request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp").forward(request,response);
                    break;
                }
                case "updateToUser":{
                    String account=request.getParameter("userAccount");
                    String name=request.getParameter("userName");
                    Integer sex= Integer.valueOf(request.getParameter("userSex"));
                    int dept= Integer.parseInt(request.getParameter("userDept"));
                    Integer status= Integer.valueOf(request.getParameter("userStatus"));
                    Integer title= Integer.valueOf(request.getParameter("userTitle"));
                    String phone=request.getParameter("userPhone");
                    String email=request.getParameter("userEmail");
                    int role= Integer.parseInt(request.getParameter("userRole"));
                    String remark1=request.getParameter("userRemark1");
                    String remark2=request.getParameter("userRemark2");
                    String remark3=request.getParameter("userRemark3");
                    String remark4=request.getParameter("userRemark4");
                    String remark5=request.getParameter("userRemark5");
                    int row = us.changeObj(account,name,dept,sex,status,title,phone,email,role,remark1,remark2,remark3,remark4,remark5);
                    if (row==1){
                        request.setAttribute("msg","updatesucc");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }else {
                        request.setAttribute("msg","updatefail");
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request,response);
                    }
                    break;
                }
                case "find": {
                    String id = request.getParameter("id");
                    if (id != null && id != "") {
                        StringBuilder sb = new StringBuilder(SqlSmt.FINDALL_BRAND);
                        sb.append(" and userAccount like \'%");
                        sb.append(id);
                        sb.append("%\'");
                        System.out.println(sb.toString());
                        ArrayList<User> user_list = new Dao<User>().loadAllObjects(User.class, sb.toString());
                        try {
                            User user = us.findObjById(Integer.parseInt(id));
                            if (user != null)
                                user_list.add(user);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        } finally {
                            request.setAttribute("user_list", user_list);
                            request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request, response);
                        }


                    }
                    break;
                }
                default: {
                    ArrayList<User> user_list = (ArrayList<User>) us.findObj();
                    request.setAttribute("user_list", user_list);
                    request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request, response);
                    break;
                }
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
    }
    


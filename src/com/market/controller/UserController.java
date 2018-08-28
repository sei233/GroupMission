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
                    String userSex= request.getParameter("userSex");
                    String userDept= request.getParameter("userDept");
                    String userStatus= request.getParameter("userStatus");
                    String userTitle= request.getParameter("userTitle");
                    String userPhone=request.getParameter("userPhone");
                    String userEmail=request.getParameter("userEmail");
                    String userRole= request.getParameter("userRole");
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
                    String id = request.getParameter("userId");
                    String account=request.getParameter("userAccount");
                    String name=request.getParameter("userName");
                    String sex= request.getParameter("userSex");
                    String dept= request.getParameter("userDept");
                    String status= request.getParameter("userStatus");
                    String title= request.getParameter("userTitle");
                    String phone=request.getParameter("userPhone");
                    String email=request.getParameter("userEmail");
                    String role= request.getParameter("userRole");
                    String remark1=request.getParameter("userRemark1");
                    String remark2=request.getParameter("userRemark2");
                    String remark3=request.getParameter("userRemark3");
                    String remark4=request.getParameter("userRemark4");
                    String remark5=request.getParameter("userRemark5");
                    int row = us.changeObj(account,name,dept,sex,status,title,phone,email,role,remark1,remark2,remark3,remark4,remark5,id);
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
                    String id =request.getParameter("id");
                    ArrayList<User> user_list = (ArrayList<User> )us.findObjByMultiCondition(id);
                    try{
                        User user = us.findObjById(Integer.parseInt(id));
                        if (user!=null)
                            user_list.add(user);
                    }catch (NumberFormatException e){
                        System.out.println("当前输入不是数字，不能查找编号");
                        e.printStackTrace();
                    }finally {
                        request.setAttribute("user_list", user_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/user_out.jsp").forward(request, response);
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
    


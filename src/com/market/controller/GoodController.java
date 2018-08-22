package com.market.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodController")
public class GoodController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");

        switch (type){
            //添加一类商品
            case "add1":{
                //跳转到添加一类商品页
                break;
            }
            //添加二类商品
            case "add2":{
                //跳转到添加二类商品页
                break;
            }
            //删除选中商品
            case "delete":{
                //删除商品并返回原页刷新
                break;
            }
            //修改选中商品
            case "change":{
                //跳转到修改商品页
                break;
            }
            //查找商品，id或名称
            case "find":{
                //在GoodService里设计方法，初始化list，判断是一类商品，还是二类商品，先看条件是否在id里面FINDID,是否相等,，是则append， 然后就模糊查找名称，拼接静态sql语句FindALL+"and GoodName=?"
                break;
            }
            //按条件查找商品
            case "findxxx":{
                //
                break;
            }
            //查看商品
            case "show":{
                //跳转到商品详情页,findID
                break;
            }
            //错误操作，返回原页
            default:break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

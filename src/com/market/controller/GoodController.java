package com.market.controller;

import com.market.bean.po.Brand;
import com.market.bean.po.Good;
import com.market.bean.po.Product;
import com.market.dao.Dao;
import com.market.service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "GoodController")
public class GoodController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        GoodService gs = new GoodService();
        LogService logs = new LogService();
        HttpSession session = request.getSession();
        String loginName = (String)session.getAttribute("loginName");
        if (type==null){
            type="";
        }
        switch (type){
            //添加一类商品
            case "add1":{
                //跳转到添加一类商品页
                request.getRequestDispatcher("/WEB-INF/jsp/firstGood_add.jsp").forward(request,response);
                break;
            }
            case "selectfg":{
                response.sendRedirect("/product_out");
//                request.getRequestDispatcher("/WEB-INF/jsp/product_out.jsp").forward(request,response);
                break;
            }
            case "choosefg":{
                Integer productId = Integer.parseInt(request.getParameter("id"));
                Product product = new Dao<Product>().loadObjextById(Product.class, SqlSmt.FINDID_PRODUCT,productId);
                request.setAttribute("product",product);
                request.getRequestDispatcher("/WEB-INF/jsp/firstGood_add.jsp").forward(request,response);
                break;
            }
            case "add1ToGood":{
                String goodName = request.getParameter("goodName");
                String goodType = request.getParameter("goodType");
                String goodBrand = request.getParameter("goodBrand");
                String goodModel = request.getParameter("goodModel");
                String goodColor = request.getParameter("goodColor");
                String goodAdoptPrice =  request.getParameter("goodAdoptPrice");
                String goodMarketPrice =  request.getParameter("goodMarketPrice");
                String goodShopPrice =  request.getParameter("goodShopPrice");
                String goodNumber =  request.getParameter("goodNumber");
                String operator = request.getParameter("operator");
                Date date = new Date();//createTime
                int row = gs.addObj(goodName,goodType,goodBrand,goodModel,goodColor,1,goodAdoptPrice,goodMarketPrice,goodShopPrice,goodNumber,date,operator);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加一类商品"+goodName,timenow);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                }
                //goodName,goodType,goodBrand,goodModel,goodColor,goodRank,goodAdoptPrice,goodMarketPrice,goodShopPrice,goodNumber,creatTime,operator
                break;
            }
            //添加二类商品
            case "add2":{
                //跳转到添加二类商品页
                ArrayList<String> type_listSG = new TypeService().getTypeList();
                ArrayList<String> brand_listSG = new BrandService().getBrandList();
                request.setAttribute("brand_listSG",brand_listSG);
                request.setAttribute("type_listSG",type_listSG);
                request.getRequestDispatcher("/WEB-INF/jsp/secondGood_add.jsp").forward(request,response);
                break;
            }
            case "add2ToGood":{
                String goodName = request.getParameter("goodName");
                String goodType = request.getParameter("goodType");
                String goodBrand = request.getParameter("goodBrand");
                String goodModel = request.getParameter("goodModel");
                String goodColor = request.getParameter("goodColor");
                String goodAdoptPrice =  request.getParameter("goodAdoptPrice");
                String goodMarketPrice =  request.getParameter("goodMarketPrice");
                String goodShopPrice =  request.getParameter("goodShopPrice");
                String goodNumber =  request.getParameter("goodNumber");
                String operator = request.getParameter("operator");
                Date date = new Date();//createTime
                int row = gs.addObj(goodName,goodType,goodBrand,goodModel,goodColor,2,goodAdoptPrice,goodMarketPrice,goodShopPrice,goodNumber,date,operator);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"添加二类商品"+goodName,timenow);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                }
                //goodName,goodType,goodBrand,goodModel,goodColor,goodRank,goodAdoptPrice,goodMarketPrice,goodShopPrice,goodNumber,creatTime,operator
                break;
            }

            //删除选中商品
            case "delete":{
                //删除商品并返回原页刷新
                String id = request.getParameter("id");
                int row = gs.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"删除商品"+id,timenow);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                }
                break;
            }
            //修改选中商品
            case "update":{
                //跳转到修改商品页
                String id = request.getParameter("id");
                Good good = gs.findObjById(Integer.parseInt(id));
                request.setAttribute("good",good);
                request.getRequestDispatcher("/WEB-INF/jsp/good_update.jsp").forward(request,response);
                break;
            }
            case "updateThis":{
                String goodId = request.getParameter("goodId");
                String goodName = request.getParameter("goodName");
                String goodMarketPrice = request.getParameter("goodMarketPrice");
                String goodShopPrice = request.getParameter("goodShopPrice");
                String goodNumber = request.getParameter("goodNumber");
//                String goodUpdateTime = request.getParameter("goodUpdateTime");
                String operator = request.getParameter("operator");
                Date date = new Date();
                int row = gs.changeObj(goodName,goodMarketPrice,goodShopPrice,goodNumber,date,operator,goodId);
                //goodName=?,goodMarketPrice=?,goodShopPrice=?,goodNumber=?,updateTime=?,operator=?
                if (row==1){
                    request.setAttribute("msg","updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                    java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                    logs.addObj(loginName,"修改商品"+goodName,timenow);
                }else {
                    request.setAttribute("msg","updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                }
                break;
            }
            //查找商品，id或名称,或条件
            case "find":{
                String id = request.getParameter("id");
                ArrayList<Good> good_list = (ArrayList<Good> )gs.findObjByMultiCondition(id);
                try{
                    Good good = gs.findObjById(Integer.parseInt(id));
                    if (good!=null)
                        good_list.add(good);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
//                    System.out.println(brand_list.size());
                    if (good_list.size()>0) {
                        request.setAttribute("good_list", good_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request, response);
                        java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                        logs.addObj(loginName,"查询商品"+id,timenow);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request, response);
                    }
                }
                break;

            }
            //查看商品
            case "show":{
                //跳转到商品详情页,findID
                String id = request.getParameter("id");

                Good good = gs.findObjById(Integer.parseInt(id));
                request.setAttribute("good",good);
                request.getRequestDispatcher("/WEB-INF/jsp/good_detail.jsp").forward(request,response);
                java.sql.Timestamp timenow=new Timestamp(System.currentTimeMillis());
                logs.addObj(loginName,"查看商品"+id+"详情",timenow);
                break;
            }
            //默认操作，返回原页
            default:
                ArrayList<Good> good_list = (ArrayList<Good>)gs.findObj();
                request.setAttribute("good_list",good_list);
                request.getRequestDispatcher("/WEB-INF/jsp/good_out.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package com.market.controller;

import com.market.bean.po.Gift;
import com.market.bean.po.Good;
import com.market.bean.po.Product;
import com.market.dao.Dao;
import com.market.service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "GiftController")
public class GiftController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        GiftService gs = new GiftService();
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
                ArrayList<String> type_list = new TypeService().getTypeList();
                ArrayList<String> brand_list = new BrandService().getBrandList();
                request.setAttribute("brand_list",brand_list);
                request.setAttribute("type_list",type_list);
                request.getRequestDispatcher("/WEB-INF/jsp/gift_add.jsp").forward(request,response);
                break;
            }
            case "addToGift":{
                String giftName = request.getParameter("giftName");
                String giftModel = request.getParameter("giftModel");
                String giftPrice = request.getParameter("giftPrice");
                String giftColor = request.getParameter("giftColor");
                String adoptPrice = request.getParameter("adoptPrice");
                String adoptDepartment =  request.getParameter("adoptDepartment");
                String giftNumber =  request.getParameter("giftNumber");
                String typeName =  request.getParameter("typeName");
                String brandName =  request.getParameter("brandName");
                System.out.println(giftName+"_"+giftModel+"_"+giftPrice+"_"+giftColor+"_"+adoptPrice+"_"+adoptDepartment+"_"+giftNumber+"_"+typeName+"_"+brandName);
                //giftName,giftModel,giftPrice,giftColor,adoptPrice,adoptDepartment,giftNumber,typeName,brandName

                int row = gs.addObj(giftName,giftModel,giftPrice,giftColor,adoptPrice,adoptDepartment,giftNumber,typeName,brandName);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }
                break;
            }

            //删除选中商品
            case "delete":{
                //删除商品并返回原页刷新
                String id = request.getParameter("id");
                int row = gs.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }
                break;
            }
            //修改选中商品
            case "update":{
                //跳转到修改商品页
                String id = request.getParameter("id");
                Gift gift = gs.findObjById(Integer.parseInt(id));
                request.setAttribute("gift",gift);
                request.getRequestDispatcher("/WEB-INF/jsp/gift_update.jsp").forward(request,response);
                break;
            }
            case "updateThis":{
                String giftName = request.getParameter("giftName");
                String giftPrice = request.getParameter("giftPrice");
                String giftNumber = request.getParameter("giftNumber");
                String giftId = request.getParameter("giftId");
                int row = gs.changeObj(giftName,giftPrice,giftNumber,giftId);
                if (row==1){
                    request.setAttribute("msg","updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                }
                break;
            }
            //查找商品，id或名称,或条件
            case "find":{
                String id = request.getParameter("id");
                ArrayList<Gift> gift_list = (ArrayList<Gift> )gs.findObjByMultiCondition(id);
                try{
                    Gift gift = gs.findObjById(Integer.parseInt(id));
                    if (gift!=null)
                        gift_list.add(gift);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
//                    System.out.println(brand_list.size());
                    if (gift_list.size()>0) {
                        request.setAttribute("gift_list", gift_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request, response);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request, response);
                    }
                }
                break;

            }
            //查看商品
            case "show":{
                //跳转到商品详情页,findID
                String id = request.getParameter("id");
                Gift gift = gs.findObjById(Integer.parseInt(id));
                request.setAttribute("gift",gift);
                request.getRequestDispatcher("/WEB-INF/jsp/gift_detail.jsp").forward(request,response);
                break;
            }
            //默认操作，返回原页
            default:
                ArrayList<Gift> gift_list = (ArrayList<Gift>)gs.findObj();
                request.setAttribute("gift_list",gift_list);
                request.getRequestDispatcher("/WEB-INF/jsp/gift_out.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

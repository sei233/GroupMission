package com.market.controller;

import com.market.bean.po.Brand;
import com.market.dao.Dao;
import com.market.service.Impl.BrandService;
import com.market.service.Impl.SqlSmt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BrandController",urlPatterns = "/BrandController")
public class BrandController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        BrandService bs = new BrandService();
        if (type==null){
            type="";
        }
        switch (type){
            case "add":{
//                request.setAttribute("brand_list",brand_list);
                request.getRequestDispatcher("/WEB-INF/jsp/brand_add.jsp").forward(request,response);
                break;
            }
            case "addToBrand" :{
                String brandName=request.getParameter("brandName");
                String brandWeb=request.getParameter("brandWeb");
                String brandDescribe=request.getParameter("brandDescribe");
                int row = bs.addObj(brandName,brandWeb,brandDescribe);
                if (row==1){
                    request.setAttribute("msg","addsucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","addfail");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }
                break;
            }

            case "delete":{
                String id = request.getParameter("id");
                int row = bs.deleteObj(Integer.parseInt(id));
                if (row==1){
                    request.setAttribute("msg","deletesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","deletefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }
//                System.out.println(id);
                break;
            }
            case "show":{
                String id = request.getParameter("id");
                Brand brand = bs.findObjById(Integer.parseInt(id));
                request.setAttribute("brand",brand);
                request.getRequestDispatcher("/WEB-INF/jsp/brand_detail.jsp").forward(request,response);
                break;
            }
            case "update":{
                String id = request.getParameter("id");
                Brand brand = bs.findObjById(Integer.parseInt(id));
                request.setAttribute("brand",brand);
                request.getRequestDispatcher("/WEB-INF/jsp/brand_update.jsp").forward(request,response);
                break;
            }
            case "updateToBrand":{
                String id = request.getParameter("brandId");
                String name = request.getParameter("brandName");
                String web = request.getParameter("brandWeb");
                String describe = request.getParameter("brandDescribe");
                int row = bs.changeObj(name,web,describe,id);
                if (row==1){
                    request.setAttribute("msg","updatesucc");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg","updatefail");
                    request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                }
                break;
            }
            case "find":{
                String id =request.getParameter("id");
                ArrayList<Brand> brand_list = (ArrayList<Brand> )bs.findObjByMultiCondition(id);
                try{
                    Brand brand = bs.findObjById(Integer.parseInt(id));
                    if (brand!=null)
                        brand_list.add(brand);
                }catch (NumberFormatException e){
                    System.out.println("当前输入不是数字，不能查找编号");
                    e.printStackTrace();
                }finally {
//                    System.out.println(brand_list.size());
                    if (brand_list.size()>0) {
                        request.setAttribute("brand_list", brand_list);
                        request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request, response);
                    }else {
                        request.setAttribute("msg", "kk");
                        request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request, response);
                    }
                }
                break;
            }
            default:{
                ArrayList<Brand> brand_list = (ArrayList<Brand>)bs.findObj();
                request.setAttribute("brand_list",brand_list);
                request.getRequestDispatcher("/WEB-INF/jsp/brand_out.jsp").forward(request,response);
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
